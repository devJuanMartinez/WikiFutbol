package com.example.wikifutbol2.ui.Adaptadores

import android.service.autofill.FieldClassification.Match
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikifutbol2.databinding.VistaPartidoHead2headBinding

class PartidoHead2HeadAdapter(private val listener : Myclick) : RecyclerView.Adapter<PartidoHead2HeadAdapter.ViewHolder>(){

    interface Myclick{
        fun onHolderClick()
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
        val character =list[position]


        holder.itemView.setOnClickListener {
            listener.onHolderClick()
        }
    }

    fun actualizarLista (newList : ArrayList<Match>){
        list.clear()
        list.addAll(newList)
    }
}