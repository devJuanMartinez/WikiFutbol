package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("competitions")
    var competitions: String?,
    @SerializedName("limit")
    var limit: Int?,
    @SerializedName("permission")
    var permission: String?
)