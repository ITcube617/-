package com.itcube.romanartur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn=findViewById(R.id.button)
        btn.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
    fun ft(view: View){
        startActivity(Intent(this,MainActivity2::class.java))
    }

}