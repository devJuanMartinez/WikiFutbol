package com.example.wikifutbol2.data.models.personas

import com.google.gson.annotations.SerializedName

data class Persona(
    @SerializedName("currentTeam")
    val currentTeam: CurrentTeam,
    @SerializedName("cateOfBirth")
    val dateOfBirth: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("section")
    val section: String,
    @SerializedName("shirtNumber")
    val shirtNumber: Int
)