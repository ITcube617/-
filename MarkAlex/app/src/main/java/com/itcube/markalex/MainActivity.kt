package com.itcube.markalex

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var butclick: Button
    lateinit var butclick1: Button
    lateinit var hammer: Button
    lateinit var batonchik: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        butclick=findViewById(R.id.button02)
        batonchik=findViewById(R.id.button01)
        butclick1=findViewById(R.id.button04)
        hammer=findViewById(R.id.button03)
        butclick1.setOnClickListener {
            startActivity(Intent(this,Bones::class.java))
        }
        hammer.setOnClickListener {
            startActivity(Intent(this,RandomMy::class.java))
        }
        batonchik.setOnClickListener {
            startActivity(Intent(this,Victorina::class.java))}
        requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }
    fun go_to_clicker(view: View){
        butclick.setOnClickListener { val i= Intent(this,Clicker::class.java)
            startActivity(i)
        }
    }
}