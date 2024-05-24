package com.example.wikifutbol2.data.models.equipos


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("season")
    var season: String?
)