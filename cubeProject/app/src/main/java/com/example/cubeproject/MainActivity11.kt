package com.example.cubeproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity11 : AppCompatActivity() {
    lateinit var but: Button
    lateinit var butt: Button
    lateinit var lay: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        but = findViewById(R.id.button8)
        butt = findViewById(R.id.button9)
        lay = findViewById(R.id.lay1)
        val count2 = intent.getIntExtra("m1", 0)

        when (count2){
            1 ->lay.setBackgroundColor(Color.argb(255, 205, 92, 92))
            2 ->lay.setBackgroundColor(Color.argb(255, 135, 206, 235))
            3 ->lay.setBackgroundColor(Color.argb(225, 159, 129, 112))
            4 ->lay.setBackgroundColor(Color.argb(224, 255, 207, 72))
            5 ->lay.setBackgroundColor(Color.argb(224, 250, 250, 210))
            else -> lay.setBackgroundResource(R.color.white)}

        butt.setOnClickListener {
            val w = Intent(this, MainActivity0::class.java)
            startActivity(w)
        }
        but.setOnClickListener {
            val m = Intent(this, MainActivity2::class.java)
            startActivity(m)
        }

    }
}