package com.hkc.jetpackcomposedemo2.network

import com.hkc.jetpackcomposedemo2.model.WeatherModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object WeatherApiClient {
    private val BASEURL = "http://api.weatherapi.com/v1/"


    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit :Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val weatherApiService : WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }


}

interface WeatherApiService{
    @GET("")
    suspend fun getWeatherData(
        @Query("key")key:String,
        @Query("q")q:String,
        @Query("days")days:String,
        @Query("aqi")aqi:String,
        @Query("alerts")alerts:String,




    ):WeatherModel

}