package com.hkc.weathertime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.gson.Gson
import okhttp3.*
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var btn_query: Button

    //定義資料結構存放Server回傳的資料
    class MyObject{
        lateinit var records: ArrayAdapter<Record>

        class Record{
            var SiteName = ""
            var Status = ""

        }

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_query = findViewById(R.id.btn_query)
        btn_query.setOnClickListener {
            //關閉按鈕避免再次查詢
            btn_query.isEnabled = false
            //發送請求
            sendRequest()

        }

    }
    //發送請求
    private fun sendRequest(){
    //環保署空氣品質指標API
    val url = "https://data.epa.gov.tw/api/v1/aqx_p_432?offset=0&limit=1000&api_key=01431860-f684-4006-b076-ade77c80b4e8"

    //建立Request.Builder物件，藉由uri()將網址傳入，再建立Request物件
        val req = Request.Builder()
                .url(url)
                .build()

    //建立OkHttpClient物件，藉由newCall()發送請求，並在enqueue()接收回傳
        OkHttpClient().newCall(req).enqueue(object : Callback{
            //發送成功執行方法
            override fun onResponse(call: Call, response: Response){
                //使用response.body?.string()取得JSON字串
                val json = response.body?.string()
                //建立Gson並使用其fromJson()方法，將Json字串以MyObject格式輸出
                val myObject = Gson().fromJson(json, MyObject::class.java)
                //顯示結果
                showDialog(myObject)
            }
            //發送失敗執行此方法
            override fun onFailure(call :Call, e: IOException){
                runOnUiThread{
                    //開啟按鈕可再次查詢
                    btn_query.isEnabled = true

                    Toast.makeText(this@MainActivity,
                            "查詢失敗$e", Toast.LENGTH_LONG).show()

                }

        }

        })


    }

    //顯示結果
    private fun showDialog(myObject: MyObject){

        //建立一個字串陣列，用於存放SiteName與Status資訊
        val items = arrayOfNulls<String>(myObject.records.size)
        //將API資料取出並建立字串，並存放到字串陣列
        myObject.records.forEachIndexed{ index, data ->
            items[index] = "地區：${data.SiteName},狀態：${data.Status}"


        }
        //切換到主執行續將畫面更新
        runOnUiThread{
            //開啟按鈕可再次查詢
            btn_query.isEnabled = true
            //建立AlertDialog物件並顯示字串陣列
            AlertDialog.Builder(this@MainActivity)
                    .setTitle("臺北市空氣品質")
                    .setItems(items, null)
                    .show()

        }

    }


}