package com.example.myapplication.web

import com.example.myapplication.data.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {

    @GET("get/climate/manualmode/bake")
    suspend fun getclimatemanualmodebake(): ClimateState

    @POST("set/climate/manualmode/bake")
    suspend fun setclimatemanualmodebake(@Body bake: ClimateBake)

    @GET("get/climate/manualmode/humidifier")
    suspend fun getclimatemanualmodehumidifier(): ClimateState

    @POST("set/climate/manualmode/humidifier")
    suspend fun setclimatemanualmodehumidifier(@Body humidifier: ClimateHumidifier)

    @GET("get/climate/manualmode/window")
    suspend fun getclimatemanualmodewindow(): ClimateState

    @POST("set/climate/manualmode/window")
    suspend fun setclimatemanualmodewindow(@Body window: ClimateWindow)

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

    @GET("get/light/illumination")
    suspend fun getlightDataIllumination(): DataIlumination

    @POST("set/light/illumination")
    suspend fun setlightDataIllumination(
        @Body
        state: DataIlumination
    )

    @GET("get/access/history")
    suspend fun getaccesshistory(): AccessHistory


    @GET("get/light/history")
    suspend fun getLightHistory(): DataLightAll

    @POST ("/set/token")
    suspend fun setToken(@Body token:TokenRequest)

    @GET("get/temperatura/history")
    suspend fun gettemperaturahistory(): ClimateHistory

    @GET("get/vlaznost/history")
    suspend fun getvlaznosthistory(): ClimateHistory

    @GET("get/CO2/history")
    suspend fun getCO2history(): ClimateHistory

    @GET( "get/climate")
    suspend fun getclimate():Climate
}