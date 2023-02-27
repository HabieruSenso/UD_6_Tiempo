package com.example.tema19mvm.data.remote

import com.example.tema19mvm.data.models.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//suspend dice que es asincrono

interface ApiService {
    @GET("find")
    suspend fun getWeather(
        @Query("appid") apikey: String = ApiRest.appid,
        @Query("q") q: String = ApiRest.q,
        @Query("units") units: String = ApiRest.units,
       // @Query("mode") mode: String = ApiRest.mode,
      //  @Query("callback") callback: String = ApiRest.callback
    ): Response<WeatherResponse>
}