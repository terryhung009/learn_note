package com.hkc.maskinfo.ViewModel


import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.hkc.maskinfo.Repository.pharmacyInfoAuto
import okhttp3.*
import java.io.IOException

public class MainViewModel : ViewModel() {



    var pharmacyInfo : pharmacyInfoAuto? = null





    //口罩資料網址
    val pharmaciesDataUrl =
        "https://raw.githubusercontent.com/thishkt/pharmacies/master/data/info.json"

    //Part 1: 宣告 OkHttpClient
    val okHttpClient = OkHttpClient().newBuilder().build()

    //Part 2: 宣告 Request，要求要連到指定網址
    val request: Request = Request.Builder().url(pharmaciesDataUrl).get().build()

    //Part 3: 宣告 Call
    val call = okHttpClient.newCall(request)


    //執行 Call 連線後，採用 enqueue 非同步方式，獲取到回應的結果資料
    val makecall = call.enqueue(object: Callback {
        override fun onFailure(call: Call, e: IOException) {

        }

        override fun onResponse(call: Call, response: Response) {

            val pharmaciesData = response.body?.string()

            pharmacyInfo = Gson().fromJson(pharmaciesData, pharmacyInfoAuto::class.java)

        }

    })

}

