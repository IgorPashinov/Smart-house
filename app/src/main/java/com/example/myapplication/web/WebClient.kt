package com.example.myapplication.web

import com.example.myapplication.data.ClimateBake
import com.example.myapplication.data.ClimateHumidifier
import com.example.myapplication.data.ClimateWindow
import com.example.myapplication.ui.ClimateFragment
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
        .baseUrl("https://google/com")
        .addConverterFactory(GsonConverterFactory.create())
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

}
