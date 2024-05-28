package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("currentMatchday")
    var currentMatchday: Int?,
    @SerializedName("endDate")
    var endDate: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("startDate")
    var startDate: String?,
    @SerializedName("winner")
    var winner: Any?
)