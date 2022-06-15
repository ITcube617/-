package com.itcube.romanartur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    var questionOn=1
    var count=0
    lateinit var text: TextView
    lateinit var text1: TextView
    lateinit var btn: Button
    lateinit var btn1: Button

    val questions =listOf <String>("Солнце больше по размеру, чем другие звёзды?", "Люди уже были на Марсе?",
        "Абсолютно все звёзды излучают свет?", "Только наша планета имеет свой спутник?", "Нил Амстронг первым прошёл по поверхности луны?",
        "Юрий Гагарин - первый космонавт в мире?", "Меркурий - самая маленькая планета в мире?", "Вселенная и Галактика - одно и тоже?"
        , "Комета в переводе с греческого означает шар?", "Америка первой запустила спутник?")
    val rAns = listOf(2,2,1,2,1,1,1,2,2,2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn=findViewById(R.id.button2)
        btn1=findViewById(R.id.button3)
        text1=findViewById(R.id.textView4)
        text=findViewById(R.id.textView)

        btn.setOnClickListener {
            showToast(1)
        }
        btn1.setOnClickListener {
            showToast(2)
        }


    }


    fun update(){
        questionOn++
        if(questionOn<=9){

            text.setText(questions.get(questionOn))
            text1.setText("Вопрос "+questionOn.toString())}
        else{
            var i = Intent(this, MainActivity3::class.java)
            i.putExtra("ff",count)
            startActivity(i) }

    }

    fun showToast(aswer:Int){
        if (aswer==rAns.get(questionOn)){
            Toast.makeText(applicationContext,"Верно!", Toast.LENGTH_SHORT).show()
            count++
            update()

        }
        else{
            Toast.makeText(applicationContext, "Oшибка!", Toast.LENGTH_SHORT ).show()
            update()

        }
    }
}