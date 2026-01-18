package com.example.final_project.api.service

import com.example.final_project.api.model.Profile
import com.example.final_project.api.model.UserActivity
import retrofit2.Call
import retrofit2.http.GET

//The Interface Definition
interface ApiService {
//    The First Endpoint: getProfile()
    @GET("final-2025/profile.json")
    suspend fun getProfile(): Profile

//    The Second Endpoint: getActivities()

    @GET("final-2025/activities.json")
    suspend fun getActivities(): List<UserActivity>
}