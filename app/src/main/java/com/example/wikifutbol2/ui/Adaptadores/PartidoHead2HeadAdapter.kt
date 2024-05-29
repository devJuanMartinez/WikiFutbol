package com.example.wikifutbol2.ui.Adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikifutbol2.data.models.partidos.Match
import com.example.wikifutbol2.databinding.VistaPartidoHead2headBinding

class PartidoHead2HeadAdapter(private val context: Context, private val listener : Myclick) : RecyclerView.Adapter<PartidoHead2HeadAdapter.ViewHolder>(){

    interface Myclick{
        fun onHolderClick(match: Match)
    }

    private val list = ArrayList<Match>()

    inner class ViewHolder(val binding: VistaPartidoHead2headBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(VistaPartidoHead2headBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val partido =list[position]

        holder.binding.tvFechaHead2Head.text = partido.utcDate?.substring(0,10)
        holder.binding.tvAwayTeamCodeHead2Head.text = partido.awayTeam?.tla
        holder.binding.tvHomeTeamCodeHead2Head.text = partido.homeTeam?.tla
        holder.binding.tvScoreAwayTeamHead2Head.text = partido.score?.fullTime?.away.toString()
        holder.binding.tvScoreHomeTeamHead2Head.text = partido.score?.fullTime?.home.toString()

        Glide.with(context).load(partido.awayTeam?.crest).into(holder.binding.imgAwayTeamHead2Head)
        Glide.with(context).load(partido.homeTeam?.crest).into(holder.binding.imgHomeTeamHead2Head)

        holder.itemView.setOnClickListener {
            listener.onHolderClick(partido)
        }
    }

    fun actualizarLista (newList: List<Match>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}