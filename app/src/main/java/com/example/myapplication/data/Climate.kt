package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

class Climate (
    @SerializedName("temperatura in")
    val temperatura: Float,
    val vlaznost: Float,
    val davlenie: Float,
    val CO2: Float
)

