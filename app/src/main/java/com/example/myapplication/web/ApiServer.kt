package com.example.myapplication.web

import com.example.myapplication.data.ClimateBake
import com.example.myapplication.data.ClimateHumidifier
import com.example.myapplication.data.ClimateWindow
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiServer {

    @GET( "get/climate/manualmode/bake")
    suspend fun getclimatemanualmodebake():ClimateBake

    @POST( "set/climate/manualmode/bake")
    suspend fun setclimatemanualmodebake(bake: ClimateBake)

    @GET( "get/climate/manualmode/humidifier")
    suspend fun getclimatemanualmodehumidifier():ClimateHumidifier

    @POST( "set/climate/manualmode/humidifier")
    suspend fun setclimatemanualmodehumidifier(humidifier: ClimateHumidifier)

    @GET( "get/climate/manulmode/window")
    suspend fun getclimatemanulmodewindow():ClimateWindow

    @POST( "set/climate/manulmode/window")
    suspend fun setclimatemanulmodewindow(window: ClimateWindow)

  /*  @GET( "get/Smart home/access")
    suspend fun getSmarthomeaccess():

*/
}