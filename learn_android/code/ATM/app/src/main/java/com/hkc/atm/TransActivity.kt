package com.hkc.atm

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hkc.atm.databinding.ActivityTransBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.net.URL
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.module.kotlin.KotlinModule
//import com.fasterxml.jackson.module.kotlin.readValue

class TransActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTransBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_trans)

        binding = ActivityTransBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = OkHttpClient.Builder()
            .build()
        val request = Request.Builder()
            .url("https://atm201605.appspot.com/h")
            .build()

        CoroutineScope(Dispatchers.IO).launch {
            var response = client.newCall(request).execute()
            response.body?.run {
//                Log.d(TAG,string())
                val json = string()
//                parseJSON(json)
                parseGSON(json)
            }
//            val reader = URL("https://atm201605.appspot.com/h")
//                .openConnection()
//                .getInputStream().bufferedReader()
//            val json = reader.use(BufferedReader::readText)
//            Log.d(TAG,json)
        }



    }

    private fun parseJSON(json: String) {
        val trans = mutableListOf<Transaction>()
        val array = JSONArray(json)
        for (i in 0 until array.length()){
            val obj =array.getJSONObject(i)
            val account = obj.getString("account")
            val date = obj.getString("date")
            val amount = obj.getInt("amount")
            val type = obj.getInt("type")
            val transaction = Transaction(account, date, amount, type)
            Log.d(TAG,transaction.toString())
            trans.add(transaction)

        }

    }

    private fun parseGSON(json: String){
        val gson = Gson()
        val trans = gson.fromJson<ArrayList<Transaction>>(json,
        object : TypeToken<ArrayList<Transaction>>(){}.type)

        trans.forEach { transaction ->
            Log.d(TAG,transaction.toString())
        }

    }

    private fun parseJackson(json:String){





    }
}