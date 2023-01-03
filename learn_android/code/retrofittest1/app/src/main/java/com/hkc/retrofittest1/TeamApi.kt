package com.hkc.retrofittest1

import retrofit2.Call
import retrofit2.http.GET

interface TeamApi {

    @GET("teams/16")
    fun getTeam(): Call<Teams>

}