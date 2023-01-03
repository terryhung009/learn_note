package com.hkc.gitdemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    private val _numberLiveData =  MutableLiveData(0)
    val numberLiveData : LiveData<Int> get() = _numberLiveData

    fun add(n:Int){
        _numberLiveData.value = _numberLiveData.value?.plus(n)

    }
    fun reset(){
        _numberLiveData.value = 0
    }

//    var number = 0
}