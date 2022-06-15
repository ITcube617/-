package com.example.cubeproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.coroutines.EmptyCoroutineContext.plus

class MainActivity : AppCompatActivity() {
    lateinit var butterbroad: Button
    lateinit var knopka: Button
    lateinit var lay: View
    var plus:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lay = findViewById(R.id.myView)
        butterbroad = findViewById(R.id.button)
        knopka = findViewById(R.id.button2)
        butterbroad.setOnClickListener {
            val q = Intent(this, MainActivity0::class.java)
            q.putExtra("m0", plus)
            startActivity(q)
        }
        knopka.setOnClickListener {
            plus++
            when (plus) {
                1 ->lay.setBackgroundColor(Color.argb(255, 205, 92, 92))
                2 ->lay.setBackgroundColor(Color.argb(255, 135, 206, 235))
                3 ->lay.setBackgroundColor(Color.argb(225, 159, 129, 112))
                4 ->lay.setBackgroundColor(Color.argb(224, 255, 207, 72))
                5 ->lay.setBackgroundColor(Color.argb(224, 250, 250, 210))
                else ->if (plus > 5) {
                    plus=0
                }
            }

        }
    }
}
