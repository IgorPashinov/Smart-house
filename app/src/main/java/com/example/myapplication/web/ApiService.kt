package com.example.myapplication.web

import com.example.myapplication.data.DataIlumination
import com.example.myapplication.data.DataLightAll
import com.example.myapplication.data.Turnoforturnon
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("get/light/turn_of_or_turn_on")
    suspend fun getlightturnoforturnon(): Turnoforturnon

    @POST("set/light/turn_of_or_turn_on")
    suspend fun setlightturnoforturnon(@Body
    state: Turnoforturnon)

    @GET("get/light/DataIllumination")
    suspend fun getlightDataIllumination(): DataIlumination

    @POST("set/light/turn_of_or_turn_on")
    suspend fun setlightturnoforturnon(@Body
    state: DataIlumination )



    @GET("get/light/history")
    suspend fun getLightHistory(): DataLightAll

}
