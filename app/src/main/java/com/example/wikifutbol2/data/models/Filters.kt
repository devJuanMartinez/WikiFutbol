package com.example.wikifutbol2.data.models


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("client")
    val client: String?
)