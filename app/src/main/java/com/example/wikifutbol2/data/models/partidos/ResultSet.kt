package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class ResultSet(
    @SerializedName("competitions")
    var competitions: String?,
    @SerializedName("count")
    var count: Int?,
    @SerializedName("draws")
    var draws: Int?,
    @SerializedName("first")
    var first: String?,
    @SerializedName("last")
    var last: String?,
    @SerializedName("losses")
    var losses: Int?,
    @SerializedName("played")
    var played: Int?,
    @SerializedName("wins")
    var wins: Int?
)