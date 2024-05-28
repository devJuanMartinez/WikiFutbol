package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class Partido(
    @SerializedName("filters")
    var filters: Filters?,
    @SerializedName("matches")
    var matches: List<Match>?,
    @SerializedName("resultSet")
    var resultSet: ResultSet?
)