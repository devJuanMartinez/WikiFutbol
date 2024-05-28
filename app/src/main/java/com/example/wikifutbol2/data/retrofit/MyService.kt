package com.example.wikifutbol2.data.retrofit

import com.example.wikifutbol2.data.models.CompeticionesResponse
import com.example.wikifutbol2.data.models.equipos.ResponseTeams
import com.example.wikifutbol2.data.models.partidos.Match
import com.example.wikifutbol2.data.models.partidos.Partido
import com.example.wikifutbol2.data.models.personas.Persona
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MyService {

    companion object{
        const val API_KEY = "72c4f464c5e64ffa9e11a1d435914ede"
    }
    @Headers("X-Auth-Token:$API_KEY")
    @GET("competitions")
    suspend fun getCompetitions(): Response<CompeticionesResponse>

    @Headers("X-Auth-Token:$API_KEY")
    @GET("persons/{id}")
    suspend fun getPersona(
        @Path("id") id : Int
    ) : Response<Persona>


    @Headers("X-Auth-Token:$API_KEY")
    @GET("competitions/{id}/teams")
    suspend fun getTeamsByCompetition(
        @Path("id") id : Int
    ) : Response<ResponseTeams>

    @Headers("X-Auth-Token: $API_KEY")
    @GET("matches/{id}")
    suspend fun getPartido(
        @Path("id") id : Int
    ) : Response<Match>

    @Headers("X-Auth-Token: $API_KEY")
    @GET("matches/{id}/head2head")
    suspend fun getPartidosAnteriores(
        @Path("id") id: Int
    ) : Response<Partido>



}