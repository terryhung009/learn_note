package com.hkc.jetpackcomposedemo2.repository

import com.hkc.jetpackcomposedemo2.model.WeatherModel
import com.hkc.jetpackcomposedemo2.network.WeatherApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WeatherRepository {
    companion object{
        fun getWeather(key:String,q:String,days:String,aqi:String,alerts:String): Flow <WeatherModel> =
            flow{
                var weather = WeatherApiClient.weatherApiService.getWeatherData(
                    key,
                    q,
                    days,
                    aqi,
                    alerts,
                )
                emit(weather)
            }.flowOn(Dispatchers.IO)
    }
}