package com.example.wikifutbol2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wikifutbol2.data.Repositorio
import com.example.wikifutbol2.data.models.Competition
import com.example.wikifutbol2.data.models.partidos.Match
import com.example.wikifutbol2.data.models.partidos.Partido
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

    private val competiciones = MutableLiveData<List<Competition?>>()

    private val ultimaPersonaSeleccionada = MutableLiveData<Persona>()

    private val partidoLiveData = MutableLiveData<Match>()
    private val listaPartidosLiveData = MutableLiveData<Partido>()

    //-----------------------------
    //Funciones que alteran los valores de cada mutable

    /**
     * @author Jose Lopez Vilchez
     * @return referencia al mutable 'competiciones' definido al principio de la clase
     */
    fun getCompetitions() : MutableLiveData<List<Competition?>> {

        viewModelScope.launch {
            val response = repositorio.getCompetitions()
            if (response.code() == 200) {
                val characterResponse = response.body()?.competitions
                characterResponse?.let {
                    competiciones.postValue(it)
                }
            }
        }

        return competiciones
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

    /**
     * @author David Trillo Gomez
     * @param id referencia a la id del partido, con la cual hace la query a la api
     * @return referencia al mutable 'partidoLiveData' definido al principio de la clase
     */

    fun getPartidoPorId(id: Int): MutableLiveData<Match> {
        viewModelScope.launch {
            val response = repositorio.getPartido(id)
            if (response.code()==200){
                response.body().let {
                    partidoLiveData.postValue(it)
                }
            }
        }

        return partidoLiveData
    }

    /**
     * @author David Trillo Gomez
     * @param match referencia al objeto de tipo Match que se quiere establecer como valor de partidoLiveData
     * @return referencia al mutable 'partidoLiveData' definido al principio de la clase
     */

    fun getPartido(match: Match): MutableLiveData<Match> {
        partidoLiveData.value = match

        return partidoLiveData
    }

    /**
     * @author David Trillo Gomez
     * @return referencia al mutable 'partidoLiveData' definido al principio de la clase
     */

    fun setPartido() = partidoLiveData

    /**
     * @author David Trillo Gomez
     * @param id referencia a la id del partido, con la cual hace la query a la api
     * @return referencia al mutable 'listaPartidosLiveData' definido al principio de la clase
     */

    fun getPartidosAnteriores(id: Int): MutableLiveData<Partido> {

        viewModelScope.launch {
            val response = repositorio.getPartidosAnteriores(id)
            if (response.code()==200){
                response.body().let {
                    listaPartidosLiveData.postValue(it)

                }
            }
        }

        return listaPartidosLiveData
    }

    /**
     * @author David Trillo Gomez
     * @return referencia al mutable 'listaPartidosLiveData' definido al principio de la clase
     */

    fun setListaPartidos() = listaPartidosLiveData
}