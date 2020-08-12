package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

class Turnoforturnon(
    val state: Boolean,
    val brightness: Int
)

class DataIlumination(
    val state: Boolean,
    @SerializedName("set the minimum illumination")
    val minIllumination: Float,
    @SerializedName("set the maximum illumination")
    val maxIllumination: Float
)
