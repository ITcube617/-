package com.itcube.markalex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class easy_vic_quest : AppCompatActivity() {
    lateinit var texty: TextView
    lateinit var bagget: Button
    lateinit var batotv: Button
    lateinit var batotv2: Button
    lateinit var batotv3: Button
    var quest=0
    var questlist= listOf("В каком году был первый полет человека в космос?\n\n 1)1961 \n\n 2)2000 \n\n 3)1967",
        "Кто был первым чловеком полетевшим в космос? \n\n 1)Ф.Гагарин \n\n 2)Ю.Гагарин \n\n 3)А.Гагарин",
        "Кто был первым человеком на Луне?\n\n 1)Нил Армстронг \n\n 2)Ф.Гагарин \n\n 3)Мэттью Макконахи",
        "Название пятой по счету планеты от солнца?\n\n 1)Венера \n\n 2)Сатурн \n\n 3)Юпитер",
        "Кто первый полетел в космос?\n\n 1)Ю.Гагарин \n\n 2)Белка и Стрелка \n\n 3)Шарик и Барбос"
    )
    var otv=listOf(1,2,1,3,2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_vic_quest)
        texty=findViewById(R.id.textView0002)
        bagget=findViewById(R.id.btn_menu)
        batotv=findViewById(R.id.btn1)
        batotv2=findViewById(R.id.btn2)
        batotv3=findViewById(R.id.btn3)
        batotv.setOnClickListener { tostek(1) }
        batotv2.setOnClickListener { tostek(2) }
        batotv3.setOnClickListener { tostek(3) }
    }
    fun tostek (answer:Int){
        if (answer === otv.get(quest)) {
            Toast.makeText(applicationContext, "Right!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Not right!", Toast.LENGTH_SHORT).show()
        }
    }
    fun updater(view: View){
        quest++
        texty.setText(questlist.get(quest))
        if (quest==4){
            Toast.makeText(applicationContext,"You can't update!", Toast.LENGTH_SHORT).show()
        }
    }
    fun backerr(view: View){
        bagget.setOnClickListener{   val ii= Intent(this,Victorina::class.java)
            startActivity(ii)}
    }
}