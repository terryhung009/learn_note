package com.hkc.gallerydemo1

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.internal.synchronized

class VolleySingleton private constructor(context: Context){
    companion object{
        private var INSTANCE: VolleySingleton ?= null
        fun getInstance (context:Context){
            INSTANCE?: kotlin.synchronized(this){
                VolleySingleton(context).also { INSTANCE = it }

            }

        }

    }

    public val requestQueue : RequestQueue by lazy{
        Volley.newRequestQueue(context.applicationContext)
//        val queue = Volley.newRequestQueue(this)

    }

}