package com.itcube.romanartur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    lateinit var text: TextView
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        btn=findViewById(R.id.button4)
        text=findViewById(R.id.textView5)


        val count = intent.getIntExtra("ff", 0)
        text.text=count.toString()+"/10"


    }

    fun replace(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
