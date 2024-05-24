package com.example.wikifutbol2.data.models.equipos


import com.google.gson.annotations.SerializedName

data class Coach(
    @SerializedName("contract")
    var contract: Contract?,
    @SerializedName("dateOfBirth")
    var dateOfBirth: String?,
    @SerializedName("firstName")
    var firstName: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("lastName")
    var lastName: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("nationality")
    var nationality: String?
)