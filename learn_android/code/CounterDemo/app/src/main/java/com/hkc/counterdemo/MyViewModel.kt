package com.hkc.counterdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val _number : MutableLiveData<Int> by lazy { MutableLiveData<Int>().also { it.value=0 }  }
    val number:LiveData<Int>
    get() = _number


//    val number= MutableLiveData<Int>(0)


//    val number : MutableLiveData<Int>
//    init {
//        number = MutableLiveData()
//        number.value = 0
//    }
    fun modifyNumber(aNumber:Int){
        _number.value = _number.value?.plus(aNumber)
    }


}