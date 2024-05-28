package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class Referee(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("nationality")
    var nationality: String?,
    @SerializedName("type")
    var type: String?
)