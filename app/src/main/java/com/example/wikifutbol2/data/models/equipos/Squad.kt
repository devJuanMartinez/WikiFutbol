package com.example.wikifutbol2.data.models.equipos


import com.google.gson.annotations.SerializedName

data class Squad(
    @SerializedName("dateOfBirth")
    var dateOfBirth: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("nationality")
    var nationality: String?,
    @SerializedName("position")
    var position: String?
)