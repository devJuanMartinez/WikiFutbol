package com.example.wikifutbol2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wikifutbol2.R
import com.example.wikifutbol2.data.models.Competition
import com.example.wikifutbol2.databinding.CompeticionesLayoutBinding
import com.example.wikifutbol2.ui.adapters.CompeticionesAdapter
import com.example.wikifutbol2.viewmodels.ElViewModel

class CompeticionesFragment : Fragment() {

    private var _binding: CompeticionesLayoutBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<ElViewModel>()

    private lateinit var adapter: CompeticionesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CompeticionesLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        configRecycler()
        viewModel.getCompetitions().observe(viewLifecycleOwner){
            adapter.updateList(it)
        }
    }

    private fun configRecycler() {

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = CompeticionesAdapter(object : CompeticionesAdapter.MyClick {
            override fun onHolderClick(competicion: Competition) {
                viewModel.setCompeticion(competicion)
                findNavController().navigate(R.id.action_competicionesFragment_to_teamsListFragment2)
            }
        })

        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


