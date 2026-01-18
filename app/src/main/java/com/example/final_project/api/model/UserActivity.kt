package com.example.final_project.api.model

import java.io.Serializable

// We add "Serializable" so we can pass the whole object to the Detail screen easily
data class UserActivity(
    val id: Int,
    val title: String,
    val date: String,
    val year: Int,
    val imageUrl: String,
    val description: String
) : Serializable