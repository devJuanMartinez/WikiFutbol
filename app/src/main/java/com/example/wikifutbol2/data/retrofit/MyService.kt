package com.example.wikifutbol2.data.retrofit

import com.example.wikifutbol2.data.models.CompeticionesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MyService {
    @GET("competitions")
    suspend fun getCompetitions(

    ): Response<CompeticionesResponse>
}