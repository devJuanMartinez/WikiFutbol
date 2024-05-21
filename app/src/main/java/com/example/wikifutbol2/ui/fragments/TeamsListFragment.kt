package com.example.wikifutbol2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wikifutbol2.data.models.equipos.Team
import com.example.wikifutbol2.ui.adaptadores.MyTeamsAdapter
import com.example.wikifutbol2.viewmodels.ElViewModel

class TeamsListFragment : Fragment() {

    private val binding = TeamsListFragment()
    private val viewModel by activityViewModels<ElViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    private fun configRecicler(id :Int){
        val layoutManager = LinearLayoutManager(requireContext())
        val list = viewModel.getTeamsByCompetition(id).value
        val adapter = list?.let {
            MyTeamsAdapter(it, object: MyTeamsAdapter.MyClick{
                override fun OnHolderClick(team: Team) {
                    viewModel.setTeamSelected(team)

                }
            })
        }
    }

}