package com.example.cubeproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity0 : AppCompatActivity() {
    lateinit var k: Button
    lateinit var kn: Button
    lateinit var kno: Button
    lateinit var knop: Button
    lateinit var knopo: Button
    lateinit var knopoc: Button
    lateinit var knopoch: Button
    lateinit var knopochk: Button
    lateinit var knopka: Button
    lateinit var lay: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main0)
        k = findViewById(R.id.button3)
        kn = findViewById(R.id.button4)
        kno = findViewById(R.id.button5)
        knop = findViewById(R.id.button6)
        knopo = findViewById(R.id.button7)
       // knopoc = findViewById(R.id.button8)
        //knopoch = findViewById(R.id.button9)
        knopochk = findViewById(R.id.button10)
        lay = findViewById(R.id.lay)
        val count2 = intent.getIntExtra("m0", 0)

        when (count2){
            1 ->lay.setBackgroundColor(Color.argb(255, 205, 92, 92))
            2 ->lay.setBackgroundColor(Color.argb(255, 135, 206, 235))
            3 ->lay.setBackgroundColor(Color.argb(225, 159, 129, 112))
            4 ->lay.setBackgroundColor(Color.argb(224, 255, 207, 72))
            5 ->lay.setBackgroundColor(Color.argb(224, 250, 250, 210))
            else -> lay.setBackgroundResource(R.color.white)}

        k.setOnClickListener {
            val a = Intent(this, MainActivity11::class.java)
            a.putExtra("m1", count2)
            startActivity(a)
        }
        kn.setOnClickListener {
            val b = Intent(this, MainActivity2::class.java)
            b.putExtra("m2", count2)
            startActivity(b)
        }
        kno.setOnClickListener {
            val c = Intent(this, MainActivity3::class.java)
            c.putExtra("m3", count2)
            startActivity(c)
        }
        knop.setOnClickListener {
            val d = Intent(this, MainActivity4::class.java)
            d.putExtra("m4", count2)
            startActivity(d)
        }
        knopo.setOnClickListener {
            val e = Intent(this, MainActivity5::class.java)
            e.putExtra("m5", count2)
            startActivity(e)
        }
//        knopoc.setOnClickListener {
//            val f = Intent(this, MainActivity6::class.java)
//            startActivity(f)
//        }
//        knopoch.setOnClickListener {
//            val g = Intent(this, MainActivity7::class.java)
//            startActivity(g)
//        }
        k.setOnClickListener {
            val h = Intent(this, MainActivity::class.java)
            startActivity(h)
        }



    }
    }
