package com.hkc.mvvmtest2.Model

class MainRepository {
    companion object{
        private var data= ArrayList<MainData>()
    }

    fun saveText(text: String){
        data.add(MainData(data.size, text))
    }

    fun getAllText() = data

}