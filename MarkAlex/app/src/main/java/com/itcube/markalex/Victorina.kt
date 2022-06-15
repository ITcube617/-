package com.itcube.markalex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Victorina : AppCompatActivity() {
    lateinit var batonk:Button
    lateinit var batonchik:Button
    lateinit var butbasker:Button
    lateinit var batonkus:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victorina)
        batonk=findViewById(R.id.button001)
        batonchik=findViewById(R.id.button002)
        batonkus=findViewById(R.id.button004)
        butbasker=findViewById(R.id.button003)
        batonk.setOnClickListener {
            startActivity(Intent(this,easy_vic_quest::class.java))
        }
        batonkus.setOnClickListener {
            startActivity(Intent(this,crazy_vic_quest::class.java))
        }
        butbasker.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        batonchik.setOnClickListener {
            startActivity(Intent(this,hard_vic_quest::class.java))
        }
    }
}