package com.example.tema19mvm.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRest {
    lateinit var service: ApiService
    val URL = "https://api.openweathermap.org/data/2.5/"
   // val URL_IMAGES = "https://image.tmdb.org/t/p/w500/"
    val appid = "b24aa989d135f4daedb2c588ec716292" //metemos nuestra api key
    val q = "Madrid,ES"
    val units = "metric"

  // val mode = "json"
    // val callback = "JSON_CALLBAC"



    init {
        initService()
    }

    private fun initService() {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiService::class.java)
    }
}
