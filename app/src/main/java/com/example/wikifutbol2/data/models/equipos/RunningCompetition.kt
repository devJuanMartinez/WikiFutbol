package com.example.wikifutbol2.data.models.equipos


import com.google.gson.annotations.SerializedName

data class RunningCompetition(
    @SerializedName("code")
    var code: String?,
    @SerializedName("emblem")
    var emblem: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?
)