package com.hkc.jetpackcomposedemo2.model

sealed class WeatherState {
    class Success(val weather : WeatherModel) : WeatherState()

    class Failure(val weather : Throwable) : WeatherState()

    object Loading : WeatherState()

    object Empty: WeatherState()
}