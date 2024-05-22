package com.example.wikifutbol2.data.retrofit

import com.example.wikifutbol2.data.models.CompeticionesResponse
import com.example.wikifutbol2.data.models.personas.Persona
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MyService {
    @GET("competitions")
    suspend fun getCompetitions(
        @Header("X-Auth-Token") authtoken : String,): Response<CompeticionesResponse>

    @GET("persons/{id}")
    suspend fun getPersona(
        @Header("X-Auth-Token") authtoken : String,
        @Path("id") id : Int
    ) : Response<Persona>
}