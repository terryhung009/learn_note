package com.hkc.mvvmtest3.ViewModel

import androidx.lifecycle.ViewModel
import com.hkc.mvvmtest3.Model.MainRepository

class MainViewModel : ViewModel(){
    private val repository= MainRepository()

    fun saveText(text: String){
        repository.saveText(text)
    }

    fun getText() = repository.getText()


}