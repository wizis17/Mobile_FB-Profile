package com.example.final_project.api

import com.example.final_project.api.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//(`object RetrofitClient`)
object RetrofitClient {
    private const val BASE_URL = "https://smlp-pub.s3.ap-southeast-1.amazonaws.com/" //URL

//     The Retrofit Instance (`val instance: ApiService by lazy`)
    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //JSON Converter
            .build() // Create config Retrofit Object
            .create(ApiService::class.java) //  Creates an implementation of your ApiService interface
    }
}