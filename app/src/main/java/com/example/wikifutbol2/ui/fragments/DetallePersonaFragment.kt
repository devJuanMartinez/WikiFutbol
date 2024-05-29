package com.example.wikifutbol2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.wikifutbol2.R
import com.example.wikifutbol2.data.models.personas.Persona
import com.example.wikifutbol2.databinding.DetallepersonaBinding
import com.example.wikifutbol2.viewmodels.ElViewModel

/**
 * @author Jose Lopez Vilchez
 *
 * Fragment muy sencillo. Simplemente observa el viewmodel y lanza una funcion
 * para rellenar con datos cada apartado. No tiene mas.
 */
class DetallePersonaFragment : Fragment() {

    private var _binding : DetallepersonaBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<ElViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DetallepersonaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPersona().observe(viewLifecycleOwner, observer)
    }

    private val observer = Observer<Persona> {
        contentHandler(it)
    }

    private fun contentHandler(persona : Persona) {

        with(binding) {

            Glide.with(requireContext())
                .load(persona.currentTeam.crest)
                .into(imagenescudo)

            imagenescudo
            costal.text = persona.shirtNumber.toString()
            nombre.text = persona.name
            nacionalidad.text = persona.nationality
            nacimiento.text = persona.dateOfBirth
            iniciocontrato.text = persona.currentTeam.contract.start
            fincontrato.text = persona.currentTeam.contract.until

            when(persona.position) {
                "Goalkeeper" -> iconoposicion.setImageResource(R.drawable.goal)
                "Defence" -> iconoposicion.setImageResource(R.drawable.shield)
                "Midfield" -> iconoposicion.setImageResource(R.drawable.midfield)
                "Offence" -> iconoposicion.setImageResource(R.drawable.sword)
            }
        }
    }

}