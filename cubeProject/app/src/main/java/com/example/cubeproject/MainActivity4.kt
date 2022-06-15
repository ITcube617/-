package com.example.cubeproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.notification.Condition
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity4 : AppCompatActivity() {
    lateinit var lay:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        lay=findViewById(R.id.lay4)
        val count2 = intent.getIntExtra("m4", 0)

        when (count2){
            1 ->lay.setBackgroundColor(Color.argb(255, 205, 92, 92))
            2 ->lay.setBackgroundColor(Color.argb(255, 135, 206, 235))
            3 ->lay.setBackgroundColor(Color.argb(225, 159, 129, 112))
            4 ->lay.setBackgroundColor(Color.argb(224, 255, 207, 72))
            5 ->lay.setBackgroundColor(Color.argb(224, 250, 250, 210))
            else -> lay.setBackgroundResource(R.color.white)}
    }
}