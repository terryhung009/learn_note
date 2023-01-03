package com.hkc.jetpackcomposedemo2.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConditionXX(
    @Json(name = "code")
    val code: Int,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "text")
    val text: String
)