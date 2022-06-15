package com.itcube.alexmax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    var questionOn =0
    lateinit var text: TextView
    lateinit var btn: Button
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var imgView: ConstraintLayout
    var countR=0
    var countN=0
    val question = listOf<String>("Кокого числа отмечается день космонавтики?\n\n 1)12 апреля \n\n 2)18 июня \n\n 3)28февраля \n\n 4)23января",
        "Как расшифровывается НЛО?\n\n 1)Неопознанный летающий объект \n\n 2)непонятный летающий объект n\n 3)инопланетяне \n\n 4)непонятное летающее облако",
        "Cколько звёзд на небе\n\n 1)Много \n\n 2)Учёные ещё не выяснили \n\n 3)674896865штук \n\n 4)Их вообще не существует",
        "Какое национальное животное в шотландии\n\n 1)Единорог \n\n 2)Слон \n\n 3)носорог \n\n 4)зебра",
        "В какой стране больше всего кофе\n\n 1)Норвегия \n\n 2)Монако \n\n 3)Индонезия \n\n 4)Бразилия",
        "кто был вторым советским летчиком-космонавтом,побывавшим в космосе?\n\n 1)Леонов \n\n 2)Титов \n\n 3)Гагарин \n\n 4)Комаров",
        "Какая температура на солнце\n\n 1)Большая \n\n 2)1млн градусов \n\n 3)6000радусов \n\n 4)3500градусов",
        "в какой галактике находится солнечая система?\n\n 1)Млечный путь\n\n 2)Андромеды\n\n 3)Галактический рукав\n\n 4)Балдж",
        "Сколько весит Юпитер\n\n 1)300тонн \n\n 2)15г \n\n 3)576946кг \n\n 4)132тонны",
        "как звали человека который первый вышел в открытый космос\n\n 1)Юрий Гагарин \n\n 2)Алексей Леонов \n\n 3)Илон Маск \n\n 4)Валентина Терешкова",
        "Какое растояние от земли до луны?\n\n 1)1000км \n\n 2)2млрд км \n\n 3)1000000000км \n\n 4)3800000км",
        "Какой формы земля?\n\n 1)В форме шара \n\n 2)Плоская \n\n 3)Квадратная \n\n 4)элипс",
        "Какое офицальное название у башни с 2012г-Башня Елизаветы \n\n 1)Big Ben \n\n 2)Спасская башня \n\n 3)Вестминский дворец \n\n 4)Лахта Центр",
        "Как называется часовой колокол Вестминтского дворца?\n\n 1)Главный колокол \n\n 2)Big Ben \n\n 3)Куранты \n\n 4)ЕГо нет",
        "Из чего састоят кольца Сатурна?\n\n 1)из песка\n\n 2)из льда\n\n 3)из камнейn\n\n 4)из гранита",
        "какая страна будет самая большая по населению в 2030г?\n\n 1)Индия\n\n 2)Китай\n\n 3)США\n\n 4)Россия",
        "в какой стране самая большая армия?\n\n 1)Пакистан\n\n 2)Евросоюз\n\n 3)Китай\n\n 4)Россия",
        "cколько спутников у юпитера?\n\n 1)59\n\n 2)24\n\n 3)6\n\n 4)80",
        "У каких планет кроме Сатурна есть кольца?\n\n 1)Уран\n\n 2)Плутон\n\n 3)Марс\n\n 4)Земля",
        "какое отчество было у Валентины Терешковой?\n\n 1)Петровна\n\n 2)Владимеровна\n\n 3)Игоревна\n\n 4)Олеговна",
        "Какая из этих калактик действительно существует?\n" + "\n" + " 1)M32\n" +
                "\n" + " 2)M16\n" + "\n" + " 3)MP40\n" + "\n" + " 4)M200","Какое созвездие из этих действительно существует?\n\n 1)Карп\n\n 2)Влажок\n\n 3)Малый пёс\n\n 4)Большой медведь")
    val rAns = listOf(1,1,2,1,4,2,3,1,2,2,4,4,3,2,2,1,3,4,1,1,3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text=findViewById(R.id.textView)
        btn=findViewById(R.id.button)
        btn1=findViewById(R.id.button2)
        btn2=findViewById(R.id.button3)
        btn3=findViewById(R.id.button4)
        imgView=findViewById(R.id.img)

        btn.setOnClickListener {
            showToast(4)
        }
        btn1.setOnClickListener {
            showToast(3)
        }
        btn2.setOnClickListener {
            showToast(2)
        }
        btn3.setOnClickListener {
            showToast(1)
        }

    }

    fun update(){

        if(questionOn<20) {
            questionOn++
            text.setText(question.get(questionOn))
            val res1:Int = getResources().getIdentifier("img_" +questionOn, "drawable", "com.itcube.alexmax")
            imgView.setBackgroundResource(res1)
        }
        else {
            val i= Intent(this,USSR20::class.java)
            i.putExtra("ff",countR)
            i.putExtra("fr",countN)
            startActivity(i)
        }

    }
    fun showToast(aswer:Int){
        if (aswer==rAns.get(questionOn)){
            Toast.makeText(applicationContext,"Правильно,вы угадали",Toast.LENGTH_SHORT).show()
            countR++
            update()


        }

        else {
            Toast.makeText(applicationContext,"Иииии это... неправильный ответ)))",Toast.LENGTH_SHORT).show()
            countN++
            update()


        }
    }
}