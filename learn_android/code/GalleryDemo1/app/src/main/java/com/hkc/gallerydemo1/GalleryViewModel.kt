package com.hkc.gallerydemo1

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    private val _photoListLive = MutableLiveData<List<PhotoItem>>()
    val photoListLive : LiveData<List<PhotoItem>>
    get() = _photoListLive

    fun fetchData(){
        val stringRequest = StringRequest(
            Request.Method.GET,
            getUrl(),
            Response.Listener {
                _photoListLive.value = Gson().fromJson(it,Pixabay::class.java).hits.toList()
            },
            Response.ErrorListener {
                Log.d("hello",it.toString())
            }



        )

//        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
//        VolleySingleton.requestQueue

//        val queue = Volley.newRequestQueue(this)
//        val url = "https://wwwjsonplaceholder.typicode.com/posts"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET,
//            url,
//            Response.Listener<String> { response ->
//                Log.d("HKT", "Response: $response")
//            },
//            Response.ErrorListener { error ->
//                Log.d("HKT", "error: $error")
//            })
//
//        queue.add(stringRequest)
        Volley.newRequestQueue(getApplication()).add(stringRequest)
    }
    fun getUrl():String{
        return "https://pixabay.com/api/?key=23365069-7e515327daa3df99a19a86efb&q=${keyWord.random()}&per_page=20"
    }

    private val keyWord = arrayOf("cat","dog","car","beauty","phone","computer","flowers","animal")
}