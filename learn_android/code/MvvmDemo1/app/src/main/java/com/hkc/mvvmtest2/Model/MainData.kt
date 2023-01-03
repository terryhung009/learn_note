package com.hkc.mvvmtest2.Model

data class MainData (
    var _id : Int,
    var content: String,
        ){
    fun print()= "$_id：$content"
}