package com.utad.ud_6_tiempo.data.models


import com.google.gson.annotations.SerializedName

data class prueba(
    val cod: String,
    val count: Int,
    val list: List<General>,
    val message: String
) {
    data class General(
        val clouds: Clouds,
        val coord: Coord,
        val dt: Int,
        val id: Int,
        val main: Main,
        val name: String,
        val rain: Any,
        val snow: Any,
        val sys: Sys,
        val weather: List<Weather>,
        val wind: Wind
    ) {
        data class Clouds(
            val all: Int
        )

        data class Coord(
            val lat: Double,
            val lon: Double
        )

        data class Main(
            @SerializedName("feels_like")
            val feelsLike: Double,
            val humidity: Int,
            val pressure: Int,
            val temp: Double,
            @SerializedName("temp_max")
            val tempMax: Double,
            @SerializedName("temp_min")
            val tempMin: Double
        )

        data class Sys(
            val country: String
        )

        data class Weather(
            val description: String,
            val icon: String,
            val id: Int,
            val main: String
        )

        data class Wind(
            val deg: Int,
            val speed: Double
        )
    }
}