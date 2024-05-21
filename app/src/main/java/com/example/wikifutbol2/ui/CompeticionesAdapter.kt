package com.example.wikifutbol2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wikifutbol2.data.models.CompeticionesResponse
import com.example.wikifutbol2.data.models.Competition
import com.example.wikifutbol2.databinding.HoldercompeticionesLayoutBinding

class CompeticionesAdapter(val listado: List<Competition>, private val listener: MyClick) : RecyclerView.Adapter<CompeticionesAdapter.ClaseCelda>() {

    interface MyClick{
        fun onHolderClick(competicion: Competition, position: Int)
    }

    inner class ClaseCelda(val binding: HoldercompeticionesLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseCelda {
        val inflater = LayoutInflater.from(parent.context)
        return ClaseCelda(HoldercompeticionesLayoutBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: ClaseCelda, position: Int) {
        val competicion = listado[position]

        if (competicion != null){

            holder.binding.nombrecompeticioens.text = competicion.name.toString()

        }

        holder.itemView.setOnClickListener {
            listener.onHolderClick(competicion, position)
        }
    }
}