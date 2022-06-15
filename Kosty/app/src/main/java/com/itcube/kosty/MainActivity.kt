package com.itcube.kosty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.SharedPreferences
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    lateinit var Button: Button
    lateinit var TextView: TextView
    lateinit var Button4: Button
    lateinit var Button3: Button
    lateinit var Button6: Button
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var img: ImageView
    var count:Int = 0
    lateinit var sPref: SharedPreferences

    val SAVED_TEXT:String  = "saved_text"
    val SAVED:String  = "saved"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button = findViewById(R.id.toast)
        Button4 = findViewById(R.id.button)
        Button3 = findViewById(R.id.button3)
        Button6 = findViewById(R.id.button6)
        textView1 = findViewById(R.id.textView9)
        textView2 = findViewById(R.id.textView13)
        img = findViewById(R.id.imageView5)

        loadText()

//        Button6.setOnClickListener{
//            val i = Intent(this,MainActivity2::class.java)
//            startActivity(i)
//        }

         //Клики
        Button.setOnClickListener {
            val countS=Button.text.toString()
            count= Integer.parseInt(countS)
            count++
            Button.text=count.toString()
        }
        //Девчачий
        Button3.setOnClickListener {
            var count1 = Button.text.toString().toInt()
            if (textView2.text.toString().toInt() <= count1) {
                count1=count1-textView2.text.toString().toInt()
                Button.text=count1.toString()
                Button3.setVisibility(View.GONE)
                val res1:Int=resources.getIdentifier(
                    "gg",
                    "drawable", "com.itcube.kosty")
                img.setImageResource(res1)
//                val fragment = BlankFragment3()
//                val fram = supportFragmentManager.beginTransaction()
//                fram.replace(R.id.frag, fragment)
//                fram.commit()

            } else {
                Toast.makeText(applicationContext, "Не хватает кликов!", Toast.LENGTH_SHORT).show()
            }
        }

            //Повседневный
        Button4.setOnClickListener {
            var count1 = Button.text.toString().toInt()
            if (textView1.text.toString().toInt() <= count1) {
                count1=count1-textView1.text.toString().toInt()
                Button.text=count1.toString()
                Button4.setVisibility(View.GONE)
                val res1:Int=resources.getIdentifier(
                    "hhh",
                    "drawable", "com.itcube.kosty")
                img.setImageResource(res1)
//                val fragment = BlankFragment2()
//                val fram = supportFragmentManager.beginTransaction()
//                fram.replace(R.id.frag, fragment)
//                fram.commit()
            } else {
                Toast.makeText(applicationContext, "Не хватает кликов!", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    fun GG(view: View) {
//        val countS=TextView.text.toString()
//        var count:Int=countS.toInt()
//        count++
//        TextView.text=count.toString()
//        Intent(this,MainActivity2::class.java).putExtra("ch",count)
//    }

    private fun saveText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString(SAVED_TEXT, Button.text.toString())
        ed.putInt(SAVED,resources.getIdentifier(
            "hhh",
            "drawable", "com.itcube.kosty"))
        ed.commit()

    }


    private fun loadText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val savedText: String? = sPref.getString(SAVED_TEXT, "")
        val saveImg:Int?=sPref.getInt(SAVED,1)
        Button.setText(savedText)
        if (saveImg != null) {
            img.setImageResource(saveImg)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        saveText()
    }

}