package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class HalfTime(
    @SerializedName("away")
    var away: Int?,
    @SerializedName("home")
    var home: Int?
)