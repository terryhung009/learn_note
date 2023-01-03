package com.hkc.atm

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hkc.atm.databinding.ActivityTransBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.net.URL
import okhttp3.OkHttpClient
import okhttp3.Request

class TransActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTransBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_trans)

        binding = ActivityTransBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = OkHttpClient.Builder()
            .build()
        val request = 

        CoroutineScope(Dispatchers.IO).launch {
//            val reader = URL("https://atm201605.appspot.com/h")
//                .openConnection()
//                .getInputStream().bufferedReader()
//            val json = reader.use(BufferedReader::readText)
//            Log.d(TAG,json)
        }



    }
}