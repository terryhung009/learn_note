package com.hkc.retrofittest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    getTeam()

    }

    private fun getTeam() {

        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://free-nba.p.rapidapi.com/")
            .build()

        val teamApi = retrofit.create(TeamApi::class.java)

        val call = teamApi.getTeam()

        call.enqueue(object : Callback<Teams> {
            override fun onFailure(call: Call<Teams>?, t: Throwable?) {

                Log.d("Huang", " get teams fail ")
            }

            override fun onResponse(call: Call<Teams>?, response: Response<Teams>) {

                Log.d("Huang", " get teams  success "+response.body())
            }
        })
    }
}