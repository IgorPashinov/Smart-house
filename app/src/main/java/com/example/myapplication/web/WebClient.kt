package com.example.myapplication.web

import com.example.myapplication.data.DataHistory
import com.example.myapplication.data.DataIlumination
import com.example.myapplication.data.Turnoforturnon
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebClient {

    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()


    val api = Retrofit.Builder()
        .baseUrl("https://google.com") // Адрес API, нужно узнать у команды
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService::class.java)

    suspend fun getTurnoforturnon(): Turnoforturnon{
        return withContext(Dispatchers.IO){
            api.getTurnoforturnon()
        }
    }
    suspend fun setTurnoforturnon(state: Turnoforturnon){
        return withContext(Dispatchers.IO) {
            api.setTurnoforturnon(state)
        }
    }

    suspend fun getIllumination(): DataIlumination {
        return withContext(Dispatchers.IO) {
            api.getIllumination
        }
    }

    suspend fun setIllumination(state: DataIlumination) {
        return withContext(Dispatchers.IO) {
            api.setIllumination(state)
        }
    }

    suspend fun getDataHistory(): DataHistory {
        return withContext(Dispatchers.IO) {
            api.getDataHistory
        }
    }


}
