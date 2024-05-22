package com.example.wikifutbol2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wikifutbol2.data.Repositorio
import com.example.wikifutbol2.data.models.Competition
import com.example.wikifutbol2.data.models.personas.Persona
import kotlinx.coroutines.launch

class ElViewModel : ViewModel() {

    //Singleton de repositorio
    private val repositorio by lazy {
        Repositorio()
    }

    //-----------------------------
    //referencias a los mutables que luego seran observados
    //Se pueden sacar sus valores con getValue()


    private val competicionSeleccionada = MutableLiveData<Competition?>()
    private val ultimaPersonaSeleccionada = MutableLiveData<Persona>()

    //-----------------------------
    //Funciones que alteran los valores de cada mutable

    /**
     * @author Jose Lopez Vilchez
     * @return referencia al mutable 'competiciones' definido al principio de la clase
     */

    fun getCompetitions() : MutableLiveData<List<Competition?>> {
        val competicionesliveData = MutableLiveData<List<Competition?>>()
        viewModelScope.launch {
            val response = repositorio.getCompetitions()
            if (response.code() == 200) {
                val characterResponse = response.body()?.competitions
                characterResponse?.let {
                    competicionesliveData.postValue(it)
                }
            }
        }

        return competicionesliveData
    }

    fun setCompeticion(competicion: Competition){
        competicionSeleccionada.value = competicion
    }

    /**
     * @author Jose Lopez Vilchez
     * @param id referencia la id asociada a la persona, con la cual hace la query a la api
     * @return referencia al mutable 'ultimaPersonaSeleccionada' definido al principio de la clase
     */

    fun getPersona(id : Int) : MutableLiveData<Persona> {

        viewModelScope.launch {
            val response = repositorio.getPersona(id)
            if (response.code() == 200) {
                val characterResponse = response.body()
                characterResponse?.let {
                    ultimaPersonaSeleccionada.postValue(it)
                }
            }
        }

        return ultimaPersonaSeleccionada
    }
}