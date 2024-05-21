package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("duration")
    var duration: String?,
    @SerializedName("fullTime")
    var fullTime: FullTime?,
    @SerializedName("halfTime")
    var halfTime: HalfTime?,
    @SerializedName("winner")
    var winner: String?
)