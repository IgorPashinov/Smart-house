package com.example.myapplication.web

import com.example.myapplication.data.DataHistory
import com.example.myapplication.data.DataIlumination
import com.example.myapplication.data.DataLightAll
import com.example.myapplication.data.Turnoforturnon
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object WebClient {

    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    var logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val okhttp = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val api = Retrofit.Builder()
        .baseUrl("https://ms.newtonbox.ru/smarthome1/").client(okhttp) // Адрес API, нужно узнать у команды
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
            api.setLightDataIllumination(state)
        }
    }

    suspend fun getDataHistory(): DataLightAll {
        return withContext(Dispatchers.IO) {
            api. getLightHistory()
        }
    }


}
