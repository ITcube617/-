package com.itcube.markalex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class crazy_vic_quest : AppCompatActivity() {
    var quest=0
    lateinit var texty: TextView
    lateinit var bagget: Button
    lateinit var batotv: Button
    lateinit var batotv2: Button
    lateinit var batotv3: Button
    var questlist= listOf("В какой из данных галактик находится 4 по размеру звезда, известная человечеству?\n\n 1)Боде \n\n 2)Черный глаз \n\n 3)Большое Магелланово облако",
        "Павший астронавт-это...? \n\n 1)Симфония 2)Литературное произведение \n\n 3)Художественная инсталляция",
        "Сколько длилась экспедиция Аполлона-15 в команде Дэвида Скотта и Джеймса Ирвина?\n\n 1)27 часов \n\n 2)67 часов \n\n 3)57 часов",
        "Выберите реально существующие места на Луне?\n\n 1)Озеро Ненависти, Море Любви \n\n 2)Море Падений, Море Льдов \n\n 3)Море Спокойствия, Море Дождей",
        "Какие координаты центра кратера Герцшпрунг являются правильными?\n\n 1)2 с.ш и 130 з.д \n\n 2)1 с.ш. и 128 з.д.\n\n 3)2 ю.ш. и 145 в.д."
    )
    var otv=listOf(3,3,2,3,2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crazy_vic_quest)
        texty=findViewById(R.id.textView0002)
        bagget=findViewById(R.id.btnmenu)
        batotv=findViewById(R.id.btnotvv1)
        batotv2=findViewById(R.id.btnotvv2)
        batotv3=findViewById(R.id.btnotvv3)
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