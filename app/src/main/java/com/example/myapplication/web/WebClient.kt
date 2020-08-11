package com.example.myapplication.web


import com.example.myapplication.data.*
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object WebClient {

    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    val api = Retrofit.Builder()
        .baseUrl("https://ms.newtonbox.ru/smarthome1/") // Адрес API, нужно узнать у команды
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiServer::class.java)

    suspend fun getclimatemanualmodebake(): ClimateBake {
        return withContext(Dispatchers.IO) {
            api.getclimatemanualmodebake()
        }
    }

    suspend fun setclimatemanualmodebake(bake: ClimateBake) {
        return withContext(Dispatchers.IO) {
            api.setclimatemanualmodebake(bake)
        }
    }
    suspend fun getclimatemanualmodehumidifier(): ClimateHumidifier {
        return withContext(Dispatchers.IO) {
            api.getclimatemanualmodehumidifier()
        }
    }

    suspend fun setclimatemanualmodehumidifier(humidifier: ClimateHumidifier) {
        return withContext(Dispatchers.IO) {
            api.setclimatemanualmodehumidifier(humidifier)
        }
    }
    suspend fun getclimatemanualmodewindow(): ClimateWindow {
        return withContext(Dispatchers.IO) {
            api.getclimatemanulmodewindow()
        }
    }

    suspend fun setclimatemanualmodewindow(window: ClimateWindow) {
        return withContext(Dispatchers.IO) {
            api.setclimatemanulmodewindow(window)
        }
    }

    suspend fun getclimateautomodetemperatura(): AutoModeTemperatura {
        return withContext(Dispatchers.IO) {
            api.getclimateautomodetemperatura()
        }
    }

    suspend fun setclimateautomodetemperatura(temperatura: AutoModeTemperatura) {
        return withContext(Dispatchers.IO) {
            api.setclimateautomodetemperatura(temperatura)
        }
    }

    suspend fun getclimateautomodevlaznost(): AutoModeVlaznost {
        return withContext(Dispatchers.IO) {
            api.getclimateautomodevlaznost()
        }
    }

    suspend fun setclimateautomodevlaznost(vlaznost: AutoModeVlaznost) {
        return withContext(Dispatchers.IO) {
            api.setclimateautomodevlaznost(vlaznost)
        }
    }


    suspend fun setaccesscall(accessDoor: AccessDoor) {
        return withContext(Dispatchers.IO) {
            api.setaccesscall(accessDoor)
        }
    }

    suspend fun getTurnoforturnon(): Turnoforturnon{
        return withContext(Dispatchers.IO){
            api.getlightturnoforturnon()
        }
    }
    suspend fun setTurnoforturnon(state: Turnoforturnon){
        return withContext(Dispatchers.IO) {
            api.setlightturnoforturnon(state)
        }
    }

    suspend fun getIllumination(): DataIlumination {
        return withContext(Dispatchers.IO) {
            api.getlightDataIllumination()
        }
    }

    suspend fun setIllumination(state: DataIlumination) {
        return withContext(Dispatchers.IO) {
            api.setlightturnoforturnon(state)
        }
    }

    suspend fun getDataHistory(): DataLightAll {
        return withContext(Dispatchers.IO) {
            api. getLightHistory()
        }
    }


}
