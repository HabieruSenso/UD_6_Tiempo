package com.example.tema19mvm.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherResponse(
    val list: List<Main>,
) : Serializable {
    data class Main(
        val humidity: Int,
        val temp: Double
    ) : Serializable
}