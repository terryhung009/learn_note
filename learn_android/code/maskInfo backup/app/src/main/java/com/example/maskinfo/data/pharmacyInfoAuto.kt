package com.example.maskinfo.data

import java.io.Serializable

data class pharmacyInfoAuto(
    val features: List<Feature>,
    val type: String
): Serializable