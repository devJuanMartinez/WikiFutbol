package com.example.wikifutbol2.data

import com.example.wikifutbol2.data.models.personas.Persona
import com.example.wikifutbol2.data.retrofit.RetrofitHelper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

class Repositorio {
    private val authtoken = "72c4f464c5e64ffa9e11a1d435914ede"

    suspend fun getCompetitions() = RetrofitHelper.retrofitService.getCompetitions()

    suspend fun getPersona(id : Int) : Response<Persona> = RetrofitHelper.retrofitService.getPersona(authtoken, id)

    suspend fun getPartido(id: Int) = RetrofitHelper.retrofitService.getPartido(id)

    suspend fun getPartidosAnteriores(id: Int) = RetrofitHelper.retrofitService.getPartidosAnteriores(id)
}