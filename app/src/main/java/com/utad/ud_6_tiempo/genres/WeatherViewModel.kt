package com.example.tema19mvm.genres

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tema19mvm.data.models.WeatherResponse
import com.example.tema19mvm.data.remote.ApiRest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    val weatherList = MutableStateFlow(listOf<WeatherResponse.Main>())
    val loading = MutableStateFlow(false)

    //dame los generos y pintamelos
    fun getWeather() {
        loading.value = true //mostramos o ocultamos el progress bar

        //captura la excepcion  si en el GenreResponse
      /*  val coroutineExceptionHandler : CoroutineExceptionHandler =
            (CoroutineExceptionHandler { _, throwable ->
                throwable.printStackTrace()
                loading.value = false
            })

        // sirve para poder coger las tareas gracias al suspend del ApiService
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler , block = {
            val response = ApiRest.service.getGenres()
            if (response.isSuccessful && response.body() != null) {
                genresList.value = response.body()?.genres!!
            } else {
                Log.i("GenresViewModel", "getGenres: ${response.errorBody()?.string()}")
            }
            loading.value = false
        })*/

        // sirve para poder coger las tareas gracias al suspend del ApiService
        viewModelScope.launch {
            val response = ApiRest.service.getWeather()
            if (response.isSuccessful && response.body() != null) {
                weatherList.value = response.body()?.list!!
            } else {
                Log.i("WeatherViewModel", "getWeather: ${response.errorBody()?.string()}")
            }
            loading.value = false
        }
    }
}