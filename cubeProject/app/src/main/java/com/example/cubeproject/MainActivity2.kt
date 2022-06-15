package com.example.cubeproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    lateinit var s: Button
    lateinit var su: Button
    lateinit var lay1: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        s = findViewById(R.id.button11)
        su = findViewById(R.id.button12)
        lay1 = findViewById(R.id.lay2)
        su.setOnClickListener {
            val w = Intent(this, MainActivity11::class.java)
            startActivity(w)
        }
        s.setOnClickListener {
            val m = Intent(this, MainActivity3::class.java)
            startActivity(m)
        }

        val count2 = intent.getIntExtra("m2", 0)

        when (count2){
            1 ->lay1.setBackgroundColor(Color.argb(255, 205, 92, 92))
            2 ->lay1.setBackgroundColor(Color.argb(255, 135, 206, 235))
            3 ->lay1.setBackgroundColor(Color.argb(225, 159, 129, 112))
            4 ->lay1.setBackgroundColor(Color.argb(224, 255, 207, 72))
            5 ->lay1.setBackgroundColor(Color.argb(224, 250, 250, 210))
            else -> lay1.setBackgroundResource(R.color.white)}
    }

}