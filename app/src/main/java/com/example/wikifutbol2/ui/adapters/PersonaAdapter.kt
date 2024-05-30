package com.example.wikifutbol2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.wikifutbol2.R
import com.example.wikifutbol2.data.models.equipos.Squad
import com.example.wikifutbol2.data.models.equipos.Team
import com.example.wikifutbol2.databinding.CeldaPersonaBinding
import com.example.wikifutbol2.viewmodels.ElViewModel

/**
 * @author Jose Lopez Vilchez
 * @param viewmodel El viewmodel en uso
 * @param lifecycleOwner Mete aqui un viewLifecycleOwner, y no pienses mas
 */
class PersonaAdapter(private val viewmodel : ElViewModel, private val lifecycleOwner: LifecycleOwner) : Adapter<PersonaAdapter.ClaseCelda>() {

    inner class ClaseCelda(val binding: CeldaPersonaBinding) : ViewHolder(binding.root)

    private var listado = ArrayList<Squad?>()

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
            if (entrada != null) {
                nombrepersona.text = entrada.name

                when (entrada.position) {
                    "Goalkeeper" -> imgtipo.setImageResource(R.drawable.goal)
                    "Defence" -> imgtipo.setImageResource(R.drawable.shield)
                    "Midfield" -> imgtipo.setImageResource(R.drawable.midfield)
                    "Offence" -> imgtipo.setImageResource(R.drawable.sword)
                }
            }
        }

        holder.itemView.setOnClickListener {
            entrada?.id?.let { valor -> viewmodel.getPersona(valor) }
            Navigation.findNavController(it).navigate(R.id.action_teamDetailFragment_to_detallePersonaFragment)
        }
    }

    fun actualizarListado (listado : ArrayList<Squad?>) {
        this.listado = listado
        notifyDataSetChanged()
    }
}