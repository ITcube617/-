package com.example.cubeproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity3 : AppCompatActivity() {
    lateinit var sus: Button
    lateinit var sussus: Button
    lateinit var lay: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        sus = findViewById(R.id.button13)
        sussus = findViewById(R.id.button14)
        lay = findViewById(R.id.lay3)
        sus.setOnClickListener {
            val g = Intent(this, MainActivity2::class.java)
            startActivity(g)
        }
        sussus.setOnClickListener {
            val l = Intent(this, MainActivity4::class.java)
            startActivity(l)
        }
        val count2 = intent.getIntExtra("m3", 0)

        when (count2){
            1 ->lay.setBackgroundColor(Color.argb(255, 205, 92, 92))
            2 ->lay.setBackgroundColor(Color.argb(255, 135, 206, 235))
            3 ->lay.setBackgroundColor(Color.argb(225, 159, 129, 112))
            4 ->lay.setBackgroundColor(Color.argb(224, 255, 207, 72))
            5 ->lay.setBackgroundColor(Color.argb(224, 250, 250, 210))
            else -> lay.setBackgroundResource(R.color.white)}
    }
}