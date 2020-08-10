package com.example.myapplication.web

import com.example.myapplication.data.ClimateBake
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebClient {

    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    val api = Retrofit.Builder()
        .baseUrl( "https://google/com")
        .addConverterFactory(GsonConverterFactory.create() )
        .build()
        .create(ApiServer::class.java)
}