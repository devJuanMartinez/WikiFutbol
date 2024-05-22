package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class HomeTeam(
    @SerializedName("crest")
    var crest: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("shortName")
    var shortName: String?,
    @SerializedName("tla")
    var tla: String?
)