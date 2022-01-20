package com.itcube.chatcube

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase


import com.itcube.chatcube.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import java.nio.file.FileSystem
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth:FirebaseAuth
    private lateinit var adapter:UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=Firebase.auth
        setUpActionBar()
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message") // в этом узле будут все сообщения (путь)
        binding.button.setOnClickListener {
            myRef.child(myRef.push().key ?: "hi") // генерация уникального ключа (пути), которого еще нет в базе данных
                .setValue(User(auth.currentUser?.displayName,binding.editCh.text.toString()))
        }
        Changel(myRef)
        initRcView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mai_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.sign_out){
            FirebaseAuth.getInstance().signOut()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun Changel(dRef: DatabaseReference) {
        dRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<User>()
                for (s in snapshot.children) {
                    val user= s.getValue(User::class.java)
                    if (user!=null) list.add(user)
                }
                adapter.submitList(list)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }
    private fun setUpActionBar(){
        val ab=supportActionBar
        Thread{
            val bMap=Picasso.get().load(auth.currentUser?.photoUrl).get()
            val dIcon=BitmapDrawable(resources, bMap)
            runOnUiThread {
                ab?.setDisplayHomeAsUpEnabled(true)
                ab?.setHomeAsUpIndicator(dIcon)
                ab?.title=auth.currentUser?.displayName
            }
        }.start()
    }

    private fun initRcView()= with((binding)){
    adapter= UserAdapter()
        RecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
        RecyclerView.adapter=adapter
        editCh.setText("")
    }
}
