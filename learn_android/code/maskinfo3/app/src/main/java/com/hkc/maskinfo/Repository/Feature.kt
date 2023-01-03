package com.hkc.maskinfo.Repository

import java.io.Serializable

data class Feature(
    val geometry: Geometry,
    val properties: Properties,
    val type: String
):Serializable