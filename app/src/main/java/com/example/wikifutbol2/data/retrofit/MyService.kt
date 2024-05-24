package com.example.wikifutbol2.data.retrofit

import com.example.wikifutbol2.data.models.CompeticionesResponse
import com.example.wikifutbol2.data.models.equipos.ResponseTeams
import com.example.wikifutbol2.data.models.personas.Persona
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface MyService {

    companion object{
        const val API_KEY = "72c4f464c5e64ffa9e11a1d435914ede"
    }
    @GET("competitions")
    suspend fun getCompetitions(
        @Header("X-Auth-Token") authtoken : String,): Response<CompeticionesResponse>

    @GET("persons/{id}")
    suspend fun getPersona(
        @Header("X-Auth-Token") authtoken : String,
        @Path("id") id : Int
    ) : Response<Persona>

    @Headers("X-Auth-Token:$API_KEY")
    @GET("competitions/{id}/teams")
    suspend fun getTeamsByCompetition(
        @Path("id") id : Int
    ) : Response<ResponseTeams>


}