package com.itcube.markalex

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class Clicker : AppCompatActivity() {
    lateinit var butext: Button
    lateinit var batext:Button
    lateinit var texty: TextView
    lateinit var butback:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clicker)
        texty=findViewById(R.id.textView3)
        butext=findViewById(R.id.button1)
        batext=findViewById(R.id.button2)
        butback=findViewById(R.id.button4)

        requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    }
    fun player2_win_clicker(view: View){
        if ((butext.text=="100")&&(batext.text!="100")){
            butext.setEnabled(false)
            texty.text="Player 2 win!!!"
        }
        else if ((batext.text!="100")&&(butext.text!="100")){
            val cstr=butext.text.toString()
            var count: Int = Integer.parseInt(cstr)
            count++
            butext.text = count.toString()

            }
        else if ((butext.text!="100")&&(batext.text=="100")){
            batext.setEnabled(false)
            texty.text="Player 1 win!!!"

        }

        }


    fun player1_win_clicker(view:View){
        if ((batext.text=="100") && (butext.text!="100")){
            texty.text="Player 1 win!!!"
        }
        else if ((batext.text!="100")&&(butext.text!="100")){
            val cstr=batext.text.toString()
            var count: Int = Integer.parseInt(cstr)
            count++
            batext.text = count.toString()
        }
    }
    fun new_game(view:View){
        texty.text="Click to win!!!"
        butext.text="0"
        batext.text="0"
    }
    fun back_clicker(view:View){
        butback.setOnClickListener{val i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}
