package com.itcube.ymap
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        weatherTask().execute()

    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
            findViewById<RelativeLayout>(R.id.cont).visibility = View.GONE
            findViewById<TextView>(R.id.errorText).visibility = View.GONE
        }


        override fun doInBackground(vararg params: String?): String? {
            var response:String?
            try{
                response = URL("https://isro.vercel.app/api/launchers").readText()
            }
            catch (e: Exception){
                response = null
            }

            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {

                val jsonObj = JSONObject(result)
                val time = jsonObj.getJSONObject("timestamp")
                val message = jsonObj.getJSONObject("message")
                val longitude = jsonObj.getJSONArray("iss_position").getJSONObject(0)
                val latitude = jsonObj.getJSONArray("iss_position").getJSONObject(1)

                val message1 = message.getString("message")
                val longitude1 = longitude.getString("pressure")
                val latitude1= latitude.getString("humidity")
                val time1:Long = time.getLong("sunrise")

                Log.i("mess",message1)



                findViewById<TextView>(R.id.textView).text = message1
                findViewById<TextView>(R.id.textView2).text = latitude1
                //findViewById<TextView>(R.id.textView3).text = longitude1
                //findViewById<TextView>(R.id.textView4).text = time1.toString()

                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<RelativeLayout>(R.id.cont).visibility = View.VISIBLE

            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }

        }
    }
}