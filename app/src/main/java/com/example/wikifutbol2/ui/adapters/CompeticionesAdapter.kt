package com.example.wikifutbol2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikifutbol2.data.models.Competition
import com.example.wikifutbol2.databinding.HoldercompeticionesLayoutBinding

class CompeticionesAdapter(private val listener: MyClick) : RecyclerView.Adapter<CompeticionesAdapter.ClaseCelda>() {

    val listado = ArrayList<Competition?>()
    interface MyClick{
        fun onHolderClick(competicion: Competition)
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
            Glide.with(holder.itemView)
                .load(competicion.emblem)
                .into(holder.binding.imgEscudo)
        }

        holder.itemView.setOnClickListener {
            if (competicion != null) {
                listener.onHolderClick(competicion)
            }
        }
    }

    fun updateList(lista: List<Competition?>) {
        listado.clear()
        listado.addAll(lista)
        notifyDataSetChanged()
    }
}