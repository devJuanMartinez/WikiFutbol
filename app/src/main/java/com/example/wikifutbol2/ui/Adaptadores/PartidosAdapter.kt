package com.example.wikifutbol2.ui.adaptadores
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikifutbol2.data.models.partidos.Match
import com.example.wikifutbol2.databinding.HolderPartidosTeamBinding

class PartidosAdapter(val context: Context, val listener: Myclick, val listaPartidos : List<Match>) : RecyclerView.Adapter<PartidosAdapter.ViewHolder>() {

    interface Myclick{
        fun onHolderClick(match: Match)
    }

    inner class ViewHolder(val binding: HolderPartidosTeamBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(HolderPartidosTeamBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return listaPartidos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val partido =listaPartidos[position]

        if (partido.status=="FINISHED"){
            holder.binding.tvAwayScoreHolderPartidos.text = partido.score?.fullTime?.away.toString()
            holder.binding.tvHomeScoreHolderPartidos.text = partido.score?.fullTime?.home.toString()
        }


        Glide.with(context).load(partido.homeTeam?.crest).into(holder.binding.imgHomeCrestHolderPartidos)
        Glide.with(context).load(partido.awayTeam?.crest).into(holder.binding.imgAwayCrestHolderPartidos)

        holder.itemView.setOnClickListener{
            listener.onHolderClick(partido)
        }
    }

//    fun actualizarLista (newList : List<Match>){
//        listaPartidos.clear()
//        listaPartidos.addAll(newList)
//        notifyDataSetChanged()
//    }
}