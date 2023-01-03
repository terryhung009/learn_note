package com.hkc.jetpackcomposedemo2.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hkc.jetpackcomposedemo2.model.WeatherState
import com.hkc.jetpackcomposedemo2.repository.WeatherRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    val weatherData : MutableState<WeatherState> = mutableStateOf(WeatherState.Empty)

    init {
        getWeather(key = "06f425b9afad42078a2192045213009",q = "Taipeishih","1",aqi = "yes",alerts = "yes" )
    }


    fun getWeather(key:String,q:String,days:String,aqi:String,alerts:String){
        viewModelScope.launch {
            WeatherRepository.getWeather(key,q,days,aqi,alerts)
                .onStart {
                    weatherData.value = WeatherState.Loading
                }
                .catch { e ->
                    weatherData.value = WeatherState.Failure(e)
                }
                .collect { response ->
                    weatherData.value = WeatherState.Success(response)
                }
        }
    }
}