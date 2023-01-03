package com.hkc.maskinfo.Repository

import java.io.Serializable

data class Geometry(
    val coordinates: List<Double>,
    val type: String
): Serializable