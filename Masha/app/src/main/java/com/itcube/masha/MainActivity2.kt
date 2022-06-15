package com.itcube.masha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val recyclerview = findViewById<RecyclerView>(R.id.rs1)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()



        data.add(ItemsViewModel(R.drawable.m, "Меркурий " ))
        data.add(ItemsViewModel(R.drawable.img_3, "Венера " ))
        data.add(ItemsViewModel(R.drawable.img, "Земля" ))



        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }

    fun rr(view: View){
        startActivity(Intent(this,MainActivity3::class.java))
    }
}