package com.example.wikifutbol2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wikifutbol2.data.models.Competition
import com.example.wikifutbol2.databinding.CompeticionesLayoutBinding
import com.example.wikifutbol2.ui.adapters.CompeticionesAdapter
import com.example.wikifutbol2.viewmodels.ElViewModel

class CompeticionesFragment : Fragment() {

    private var _binding: CompeticionesLayoutBinding? = null
    private var binding get() = _binding!!

    private val viewModel by activityViewModels<ElViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CompeticionesLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        configRecycler()
        viewModel.getCompetitions().observe(viewLifecycleOwner){

        }
    }
    private fun configRecycler(list: List<Competition>) {

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = CompeticionesAdapter(list as ArrayList<Competition>, object : CompeticionesAdapter.MyClick {
            override fun onHolderClick(competicion: Competition) {
                viewModel.setCompeticion(competicion)
//                findNavController().navigate(R.id.)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

