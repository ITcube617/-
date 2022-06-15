package com.itcube.masha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var Btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Btn=findViewById(R.id.button)
        Btn.setOnClickListener {
            val i = Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
    }

}