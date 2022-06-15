package com.itcube.markalex

import android.content.Intent
import android.os.Bundle
import android.content.pm.ActivityInfo
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class Bones : AppCompatActivity() {
    private var mLeftImageView: ImageView? = null
    private var mRightImageView: ImageView? = null
    private  lateinit var batonk:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bones)
        val rollDicesButton = findViewById<View>(R.id.button_show1) as Button
        mLeftImageView = findViewById<View>(R.id.imageview_left) as ImageView
        mRightImageView = findViewById<View>(R.id.imageview_right) as ImageView
        rollDicesButton.setOnClickListener { // Получим случайные числа для двух костей
            val value1 = randomDiceValue()
            val value2 = randomDiceValue()
            batonk=findViewById(R.id.button_back)

            // Находим ресурс с этими числами
            val res1 = resources.getIdentifier(
                "img_$value1",
                "drawable", "spb.mogilkin.minigames"
            )
            val res2 = resources.getIdentifier(
                "img_$value2",
                "drawable", "spb.mogilkin.minigames"
            )
            mLeftImageView!!.setImageResource(res1)
            mRightImageView!!.setImageResource(res2)
        }
        requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        batonk.setOnClickListener {
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun randomDiceValue(): Int {
        val random = Random()
        return random.nextInt(6) +1
    }
//    fun backbacker(view:View){
//         val i= Intent(this,MainActivity::class.java)
//            startActivity(i)
//
//    }
}