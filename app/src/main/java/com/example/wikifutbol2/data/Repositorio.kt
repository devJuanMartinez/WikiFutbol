package com.example.wikifutbol2.data

import com.example.wikifutbol2.data.models.equipos.ResponseTeams
import com.example.wikifutbol2.data.models.personas.Persona
import com.example.wikifutbol2.data.retrofit.RetrofitHelper
import retrofit2.Response

class Repositorio {

    suspend fun getCompetitions() = RetrofitHelper.retrofitService.getCompetitions()

    suspend fun getPersona(id : Int) : Response<Persona> = RetrofitHelper.retrofitService.getPersona(id)


    suspend fun getPartido(id: Int) = RetrofitHelper.retrofitService.getPartido(id)

    suspend fun getPartidosAnteriores(id: Int) = RetrofitHelper.retrofitService.getPartidosAnteriores(id)

    suspend fun getTeamsByCompetition(id : Int) : Response<ResponseTeams> = RetrofitHelper.retrofitService.getTeamsByCompetition(id)

    suspend fun getPartidosByEquipoId(id: Int) = RetrofitHelper.retrofitService.getPartidosByEquipoId(id)
    suspend fun getTeamById(id: Int) = RetrofitHelper.retrofitService.getTeamsById(id)




}