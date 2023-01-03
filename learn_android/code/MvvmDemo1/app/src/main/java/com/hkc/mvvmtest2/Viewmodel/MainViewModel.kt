package com.hkc.mvvmtest2.Viewmodel

import androidx.lifecycle.ViewModel
import com.hkc.mvvmtest2.Model.MainRepository

class MainViewModel : ViewModel(){
    private val repository= MainRepository()

    fun saveText(text: String){
        repository.saveText(text)
    }
}