package com.example.wikifutbol2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.wikifutbol2.data.models.personas.Persona
import com.example.wikifutbol2.databinding.CeldaPersonaBinding

class PersonaAdapter(val listado: ArrayList<Persona>) : Adapter<PersonaAdapter.ClaseCelda>() {

    inner class ClaseCelda(val binding: CeldaPersonaBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CeldaPersonaBinding.inflate(layoutInflater, parent, false)
        return ClaseCelda(binding)
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: ClaseCelda, position: Int) {
        val entrada = listado[position]

        with(holder.binding) {
            //TODO implementar logica
        }

        holder.itemView.setOnClickListener {
            //TODO implementar logica
        }
    }
}