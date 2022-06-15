package com.itcube.ymap

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.io.IOException
import java.util.*


/**
 * В этом примере показывается карта и камера выставляется на указанную точку.
 * Не забудьте запросить необходимые разрешения.
 */
class MainActivity : Activity() {

    val client = OkHttpClient()

    /**
     * Замените "your_api_key" валидным API-ключом.
     * Ключ можно получить на сайте https://developer.tech.yandex.ru/
     */
    private val MAPKIT_API_KEY = "9a12ca15-1f24-4b49-a554-28a04724494e"
    private val TARGET_LOCATION = Point(59.945933, 30.320045)
    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * Задайте API-ключ перед инициализацией MapKitFactory.
         * Рекомендуется устанавливать ключ в методе Application.onCreate(),
         * но в данном примере он устанавливается в Activity.
         */
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        /**
         * Инициализация библиотеки для загрузки необходимых нативных библиотек.
         * Рекомендуется инициализировать библиотеку MapKit в методе Activity.onCreate()
         * Инициализация в методе Application.onCreate() может привести к лишним вызовам и увеличенному использованию батареи.
         */
        MapKitFactory.initialize(this)
        // Создание MapView.
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        mapView = findViewById<View>(R.id.mapview) as MapView

        // Перемещение камеры в центр Санкт-Петербурга.
        mapView!!.map.move(
            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5F),
            null
        )

    }


}



