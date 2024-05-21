package com.example.wikifutbol2.data.models.personas

import com.google.gson.annotations.SerializedName

data class RunningCompetition(
    @SerializedName("code")
    val code: String,
    @SerializedName("emblem")
    val emblem: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)