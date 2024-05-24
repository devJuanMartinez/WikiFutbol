package com.example.wikifutbol2.data

import com.example.wikifutbol2.data.models.equipos.ResponseTeams
import com.example.wikifutbol2.data.models.personas.Persona
import com.example.wikifutbol2.data.retrofit.RetrofitHelper
import retrofit2.Response

class Repositorio {

    suspend fun getCompetitions() = RetrofitHelper.retrofitService.getCompetitions()
    suspend fun getPersona(id : Int) : Response<Persona> = RetrofitHelper.retrofitService.getPersona(id)

    suspend fun getTeamsByCompetition(id : Int) : Response<ResponseTeams> = RetrofitHelper.retrofitService.getTeamsByCompetition(id)
}