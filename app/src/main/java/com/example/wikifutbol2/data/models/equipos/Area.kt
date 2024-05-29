package com.example.wikifutbol2.data.models.equipos


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("code")
    var code: String?,
    @SerializedName("flag")
    var flag: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?
)