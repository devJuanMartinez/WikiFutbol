package com.example.wikifutbol2.data.models.equipos


import com.google.gson.annotations.SerializedName

data class ResponseTeams(
    @SerializedName("competition")
    var competition: Competition?,
    @SerializedName("count")
    var count: Int?,
    @SerializedName("filters")
    var filters: Filters?,
    @SerializedName("season")
    var season: Season?,
    @SerializedName("teams")
    var teams: List<Team>?
)