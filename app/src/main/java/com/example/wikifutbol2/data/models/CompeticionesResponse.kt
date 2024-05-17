package com.example.wikifutbol2.data.models


import com.google.gson.annotations.SerializedName

data class CompeticionesResponse(
    @SerializedName("competitions")
    val competitions: List<Competition?>?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("filters")
    val filters: Filters?
)