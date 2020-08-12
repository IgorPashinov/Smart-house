package com.example.myapplication.web

import com.example.myapplication.data.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiServer {

    @GET("get/climate/manualmode/bake")
    suspend fun getclimatemanualmodebake(): ClimateBake

    @POST("set/climate/manualmode/bake")
    suspend fun setclimatemanualmodebake(@Body bake: ClimateBake)

    @GET("get/climate/manualmode/humidifier")
    suspend fun getclimatemanualmodehumidifier(): ClimateHumidifier

    @POST("set/climate/manualmode/humidifier")
    suspend fun setclimatemanualmodehumidifier(@Body humidifier: ClimateHumidifier)

    @GET("get/climate/manulmode/window")
    suspend fun getclimatemanulmodewindow(): ClimateWindow

    @POST("set/climate/manulmode/window")
    suspend fun setclimatemanulmodewindow(@Body window: ClimateWindow)

    @POST("set/access/call")
    suspend fun setaccesscall(@Body accessDoor: AccessDoor)

    @GET("get/climate/automode/temperatura")
    suspend fun getclimateautomodetemperatura(): AutoModeTemperatura

    @POST("set/climate/automode/temperatura")
    suspend fun setclimateautomodetemperatura(@Body autoModeTemperatura: AutoModeTemperatura)

    @GET("get/climate/automode/vlaznost")
    suspend fun getclimateautomodevlaznost(): AutoModeVlaznost

    @POST("set/climate/automode/vlaznost")
    suspend fun setclimateautomodevlaznost(@Body autoModeVlaznost: AutoModeVlaznost)


    @GET("get/light/turn_of_or_turn_on")
    suspend fun getlightturnoforturnon(): Turnoforturnon

    @POST("set/light/turn_of_or_turn_on")
    suspend fun setlightturnoforturnon(
        @Body
        state: Turnoforturnon
    )

    @GET("get/light/DataIllumination")
    suspend fun getlightDataIllumination(): DataIlumination

    @POST("set/light/turn_of_or_turn_on")
    suspend fun setlightturnoforturnon(
        @Body
        state: DataIlumination
    )


    @GET("get/light/history")
    suspend fun getLightHistory(): DataLightAll

}