package com.itcube.markalex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class hard_vic_quest : AppCompatActivity() {
    lateinit var texty:TextView
    lateinit var bagget: Button
    lateinit var batotv:Button
    lateinit var batotv2:Button
    lateinit var batotv3:Button
    var quest=0
    var questlist= listOf("Какая из данных компаний разработала косм.корабль Dragon?\n\n 1)Nasa \n\n 2)SpaceX \n\n 3)CNSA",
        "Каким муз.инструментом впервые сыграли в космосе? \n\n 1)Губная гармошка \n\n 2)Трещетка \n\n 3)Что-то из перкуссии",
        "Какая из данных звезд является самой крупной?\n\n 1)UY щита \n\n 2)Вэстерланд \n\n 3)АН скорпиона",
        "Какой из данных спутников был первым запущенным искусственным спутником Земли?\n\n 1)Спутник-1 \n\n 2)Спутник-3 \n\n 3)ПС-1",
        "Какой из данных док-ов запрещает присвоение Луны любому гос-ву?\n\n 1)Международный пакт о суверенитете космических тел \n\n 2)Договор о космосе \n\n 3)N.N.M"
    )
    var otv=listOf(2,1,1,1,2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard_vic_quest)
        texty=findViewById(R.id.textView4)
        bagget=findViewById(R.id.button8)
        batotv=findViewById(R.id.button_otv1)
        batotv2=findViewById(R.id.button_otv2)
        batotv3=findViewById(R.id.button_otv3)
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
    fun update(view: View){
        quest++
        texty.setText(questlist.get(quest))
        if (quest==4){
            Toast.makeText(applicationContext,"You can't update!",Toast.LENGTH_SHORT).show()
        }
    }
    fun backer(view:View){
        bagget.setOnClickListener{   val ii= Intent(this,Victorina::class.java)
            startActivity(ii)}
    }
}