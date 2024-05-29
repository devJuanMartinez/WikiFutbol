package com.example.wikifutbol2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.wikifutbol2.data.models.equipos.Team
import com.example.wikifutbol2.databinding.TeamDetailsFragmentBinding
import com.example.wikifutbol2.viewmodels.ElViewModel

class TeamDetailFragment : Fragment() {

    private lateinit var binding: TeamDetailsFragmentBinding
    private val viewModel by activityViewModels<ElViewModel>()

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

        viewModel.getTeamSelected().observe(viewLifecycleOwner){
            fillTeamDetails(it)
        }


//        val team = viewModel.getTeamSelected()
//        if (team != null) {
//            fillTeamDetails(team)
//        }
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
}