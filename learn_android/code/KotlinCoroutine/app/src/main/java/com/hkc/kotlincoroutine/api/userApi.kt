package com.hkc.kotlincoroutine.api

import android.util.Log


data class User(val name:String,val address :String)

val userServiceApi:UserServiceApi by lazy {
    val retrofit = retrofit2.Retrofit.Builder()
        .client(OkHttpClient.Builder().addInterceptor{
            it.proceed(it.request().apply{
                Log.d("jason","request:${code()}")
            }
                .build())

        }


        )

}

interface UserServiceApi {
    
}