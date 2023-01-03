package com.hkc.mvvmtest2.Viewmodel

import androidx.lifecycle.ViewModel
import com.hkc.mvvmtest2.Model.MainRepository

class ResultViewModel : ViewModel() {
    private val repository= MainRepository()

    fun getAllText() = repository.getAllText()
}