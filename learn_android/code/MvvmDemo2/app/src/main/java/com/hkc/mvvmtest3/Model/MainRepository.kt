package com.hkc.mvvmtest3.Model

import androidx.lifecycle.MutableLiveData

class MainRepository {
    companion object{
        private var data= MutableLiveData<String>()
    }

    init {
        data.value= "init"
    }

    fun saveText(text: String){
        data.value= text
    }

    fun getText() = data


}