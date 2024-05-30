package com.example.wikifutbol2.ui.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.wikifutbol2.data.models.equipos.Team
import com.example.wikifutbol2.databinding.HolderTeamsBinding

class MyTeamsAdapter(
    val list : List<Team>,
    val context: Context,
    private val listener : MyClick
    ) : RecyclerView.Adapter<MyTeamsAdapter.HolderView>() {

    interface MyClick{
        fun onHolderClick(team: Team)
    }
    inner class HolderView(val binding: HolderTeamsBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderTeamsBinding.inflate(inflater,parent,false)
        return HolderView(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        val equipo = list[position]

        if(equipo == list[itemCount - 1]) holder.binding.divider.isVisible = false

        Glide.with(context).load(equipo.crest).into(holder.binding.ivCrest)
        holder.binding.tvTeamName.text = equipo.name + " (" + equipo.tla + ")"
        holder.binding.tvCoach.text = equipo.coach?.name
        holder.binding.tvStadium.text = equipo.venue

        holder.itemView.setOnClickListener{
            listener.onHolderClick(equipo)
        }
    }
}