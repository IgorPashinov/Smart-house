package com.example.myapplication.web

import com.example.myapplication.data.ClimateBake
import com.example.myapplication.data.ClimateHumidifier
import com.example.myapplication.data.ClimateWindow
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiServer {

    @GET( "get /climate/manual mode/bake")
    suspend fun getclimatemanualmodebake():ClimateBake

    @POST( "set /climate/manual mode/bake")
    suspend fun setclimatemanualmodebake(bake: ClimateBake)

    @GET( "get /climate/manual mode/humidifier")
    suspend fun getclimatemanualmodehumidifier():ClimateHumidifier

    @POST( "set /climate/manual mode/humidifier")
    suspend fun setclimatemanualmodehumidifier(humidifier: ClimateHumidifier)

    @GET( "get/climate/manul mode/window")
    suspend fun getclimatemanulmodewindow():ClimateWindow

    @POST( "set/climate/manul mode/window")
    suspend fun setclimatemanulmodewindow(window: ClimateWindow)


}