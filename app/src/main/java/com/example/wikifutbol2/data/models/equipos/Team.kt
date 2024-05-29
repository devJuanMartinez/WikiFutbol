package com.example.wikifutbol2.data.models.equipos


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("address")
    var address: String?,
    @SerializedName("area")
    var area: Area?,
    @SerializedName("clubColors")
    var clubColors: String?,
    @SerializedName("coach")
    var coach: Coach?,
    @SerializedName("crest")
    var crest: String?,
    @SerializedName("founded")
    var founded: Int?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("lastUpdated")
    var lastUpdated: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("runningCompetitions")
    var runningCompetitions: List<RunningCompetition?>?,
    @SerializedName("shortName")
    var shortName: String?,
    @SerializedName("squad")
    var squad: List<Squad?>?,
    @SerializedName("staff")
    var staff: List<Any?>?,
    @SerializedName("tla")
    var tla: String?,
    @SerializedName("venue")
    var venue: String?,
    @SerializedName("website")
    var website: String?
)