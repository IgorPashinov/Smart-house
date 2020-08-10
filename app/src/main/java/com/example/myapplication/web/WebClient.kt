package com.example.myapplication.web

import com.example.myapplication.data.DataHistory
import com.example.myapplication.data.DataIlumination
import com.example.myapplication.data.DataLightAll
import com.example.myapplication.data.Turnoforturnon
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
        .create(ApiService::class.java)

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
