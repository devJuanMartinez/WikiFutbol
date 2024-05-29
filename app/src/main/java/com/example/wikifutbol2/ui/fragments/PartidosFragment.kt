package com.example.wikifutbol2.ui.fragments



import android.net.Uri

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels


import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.bumptech.glide.Glide
import com.example.wikifutbol2.R
import com.example.wikifutbol2.data.models.partidos.Match
import com.example.wikifutbol2.data.models.partidos.Partido
import com.example.wikifutbol2.databinding.FragmentPartidoBinding

import com.example.wikifutbol2.ui.Adaptadores.PartidoHead2HeadAdapter
import com.example.wikifutbol2.ui.MainActivity
import com.example.wikifutbol2.viewmodels.ElViewModel
import java.io.InputStream


class PartidosFragment : Fragment() {


    private lateinit var binding: FragmentPartidoBinding
    private val myViewModel by activityViewModels<ElViewModel>()
    private lateinit var adapter: PartidoHead2HeadAdapter



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
            fillData(it)
        }


    }

    private fun fillData(match: Match){

        binding.tvFechaPartido.text = match.utcDate?.substring(0,10)

        binding.tvHomeScorePartido.text = match.score?.fullTime?.home.toString()
        binding.tvAwayScorePartido.text = match.score?.fullTime?.away.toString()

        binding.tvAwayTeamPartido.text = match.awayTeam?.name
        binding.tvHomeTeamPartido.text = match.homeTeam?.name

        binding.tvAwayTeamCodePartido.text = "(" + match.awayTeam?.tla + ")"
        binding.tvHomeTeamCodePartido.text = "(" + match.homeTeam?.tla + ")"

        binding.tvJornadaPartido.text = "Jornada " + match.matchday

        (requireActivity() as MainActivity).supportActionBar?.title = match.homeTeam?.tla + " - " + match.awayTeam?.tla

        Glide.with(requireContext()).load(match.competition?.emblem).placeholder(R.drawable.ic_launcher_foreground).into(binding.imgLogoCompetitionPartido)
        Glide.with(requireContext()).load(match.homeTeam?.crest).placeholder(R.drawable.ic_launcher_foreground).into(binding.imgHomeTeamPartido)
        Glide.with(requireContext()).load(match.awayTeam?.crest).placeholder(R.drawable.ic_launcher_foreground).into(binding.imgAwayTeamPartido)

        binding.recyclerViewHead2Head.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        adapter = PartidoHead2HeadAdapter(requireContext(), object : PartidoHead2HeadAdapter.Myclick{
            override fun onHolderClick(match: Match) {

                myViewModel.getPartido(match)
                findNavController().navigate(R.id.action_partidosFragment_self)
            }

        })

        binding.recyclerViewHead2Head.adapter = adapter


        match.id?.let {
            myViewModel.getPartidosAnteriores(it).observe(viewLifecycleOwner){partido->

                partido?.matches?.let { list->
                    adapter.actualizarLista(list)
                }

            }
        }





    }
}