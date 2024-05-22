package com.example.wikifutbol2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.wikifutbol2.R
import com.example.wikifutbol2.data.models.partidos.Match
import com.example.wikifutbol2.data.models.partidos.Partido
import com.example.wikifutbol2.databinding.FragmentPartidoBinding
import com.example.wikifutbol2.ui.MainActivity
import com.example.wikifutbol2.viewmodels.ElViewModel

class PartidosFragment : Fragment() {


    private lateinit var binding: FragmentPartidoBinding
    private val myViewModel by activityViewModels<ElViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPartidoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.getPartido(441789).observe(viewLifecycleOwner){
            configRecyclerView(it)
        }


    }

    private fun configRecyclerView(match: Match){

        binding.tvFechaPartido.text = match.utcDate?.substring(0,10)
        binding.tvHomeScorePartido.text = match.score?.fullTime?.home.toString()
        binding.tvAwayScorePartido.text = match.score?.fullTime?.away.toString()
        binding.tvAwayTeamCodePartido.text = match.awayTeam?.shortName
        binding.tvHomeTeamCodePartido.text = match.homeTeam?.shortName
        binding.tvJornadaPartido.text = "Jornada " + match.matchday

        (requireActivity() as MainActivity).supportActionBar?.title = match.homeTeam?.tla + "-" + match.awayTeam?.tla

        Glide.with(requireContext()).load(match.competition?.emblem).placeholder(R.drawable.ic_launcher_foreground).into(binding.imgLogoCompetitionPartido)
        Glide.with(requireContext()).load("https://crests.football-data.org/12.svg").placeholder(R.drawable.ic_launcher_foreground).into(binding.imgHomeTeamPartido)
        Glide.with(requireContext()).load(match.awayTeam?.crest).placeholder(R.drawable.ic_launcher_foreground).into(binding.imgAwayTeamPartido)

    }
}