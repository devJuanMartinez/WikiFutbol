package com.example.wikifutbol2.data

import com.example.wikifutbol2.data.retrofit.RetrofitHelper
class Repositorio {

    suspend fun getCompetitions() = RetrofitHelper.retrofitService.getCompetitions()


}