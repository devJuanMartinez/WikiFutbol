package com.example.wikifutbol2.data.models


import com.google.gson.annotations.SerializedName

data class Winner(
    @SerializedName("address")
    val address: String?,
    @SerializedName("clubColors")
    val clubColors: String?,
    @SerializedName("crest")
    val crest: String?,
    @SerializedName("founded")
    val founded: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastUpdated")
    val lastUpdated: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("shortName")
    val shortName: String?,
    @SerializedName("tla")
    val tla: String?,
    @SerializedName("venue")
    val venue: Any?,
    @SerializedName("website")
    val website: String?
)