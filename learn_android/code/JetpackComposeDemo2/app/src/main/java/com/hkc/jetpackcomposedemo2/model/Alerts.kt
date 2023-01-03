package com.hkc.jetpackcomposedemo2.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Alerts(
    @Json(name = "alert")
    val alert: List<Any>
)