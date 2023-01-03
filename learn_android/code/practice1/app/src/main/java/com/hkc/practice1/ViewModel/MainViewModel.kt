package com.hkc.practice1.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel(){
    val message = MutableLiveData<String>()
    val times = MutableLiveData<Int>()
    private var counter = 0
    private var secret = Random.nextInt(10)+1
//    private var secret = 0



    fun guess(num: Int){
//        secret = Random.nextInt(10)+1
        val text= when(num-secret){
            0 -> "答對了"
            in 1..10 -> "小一點"
            else -> "大一點"

        }
        message.value = text
        counter++
        times.value = counter


    }
}