package com.example.wikifutbol2.data.models.equipos


import com.google.gson.annotations.SerializedName

data class Contract(
    @SerializedName("start")
    var start: String?,
    @SerializedName("until")
    var until: String?
)