package com.itcube.alexmax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class USSR20 : AppCompatActivity() {
    lateinit var textR:TextView
    lateinit var textN:TextView
    lateinit var textP:TextView
    var p:Float = 0.0f
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ussr20)

        textR=findViewById(R.id.textView3)
        textN=findViewById(R.id.textView6)
        textP=findViewById(R.id.textView4)
        val contN=intent.getIntExtra("fr",0)
        val contR=intent.getIntExtra("ff",0)

        p=((contR.toFloat() / 21.0f*100.0f))

        textR.setText(contR.toString())
        textN.setText(contN.toString())
        textP.text= "$p%"

    }
}