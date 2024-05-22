package com.example.wikifutbol2.data.models.partidos


import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("area")
    var area: Area?,
    @SerializedName("awayTeam")
    var awayTeam: AwayTeam?,
    @SerializedName("competition")
    var competition: Competition?,
    @SerializedName("group")
    var group: Any?,
    @SerializedName("homeTeam")
    var homeTeam: HomeTeam?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("lastUpdated")
    var lastUpdated: String?,
    @SerializedName("matchday")
    var matchday: Int?,
    @SerializedName("odds")
    var odds: Odds?,
    @SerializedName("referees")
    var referees: List<Referee?>?,
    @SerializedName("score")
    var score: Score?,
    @SerializedName("season")
    var season: Season?,
    @SerializedName("stage")
    var stage: String?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("utcDate")
    var utcDate: String?
)