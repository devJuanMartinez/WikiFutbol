package com.example.wikifutbol2.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikifutbol2.data.models.equipos.Team
import com.example.wikifutbol2.databinding.TeamDetailsFragmentBinding
import com.example.wikifutbol2.ui.adapters.PersonaAdapter
import com.example.wikifutbol2.viewmodels.ElViewModel


class TeamDetailFragment : Fragment() {

    private lateinit var binding: TeamDetailsFragmentBinding
    private val viewModel by activityViewModels<ElViewModel>()
    private lateinit var adaptadorJugadores : PersonaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TeamDetailsFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getTeamSelected().observe(viewLifecycleOwner){team ->
            fillTeamDetails(team)
            binding.tvWebsite.setOnClickListener{
                val uri = Uri.parse(team.website)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }


        // Te dejo el tema de rellenar el recyclerview de jugadores apartadillo del resto :)
        configuracionRecyclerJugadores()




    }

    private fun fillTeamDetails(team: Team){

        Glide.with(requireContext()).load(team.crest).into(binding.ivTeamCrest)
        binding.tvTeamDetName.text = team.name
        binding.tvTla.text = team.tla
        binding.tvShortName.text = team.shortName
        binding.tvFounded.text = team.founded.toString()
        binding.tvCoachName.text = team.coach?.name
        binding.tvStadiumName.text = team.venue
        binding.tvAddress.text = team.address
        binding.tvWebsite.text = team.website
    }

    /**
     * @author Jose Lopez Vilchez
     *
     * Se encarga de manejar el recyclerview de jugadores por su cuenta,
     * Observa el viewmodel por si solo, no necesitas tocarlo ni nada.
     */
    private fun configuracionRecyclerJugadores() {
        val layoutmanager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        adaptadorJugadores = PersonaAdapter(viewModel, viewLifecycleOwner)
        binding.rvPlayers.layoutManager = layoutmanager
        binding.rvPlayers.adapter = adaptadorJugadores
    }
}