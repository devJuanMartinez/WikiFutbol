package com.example.wikifutbol2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wikifutbol2.R
import com.example.wikifutbol2.databinding.HomeLayoutBinding

class HomeFragment : Fragment() {

    private var _binding: HomeLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val misPreferencias = requireContext().getSharedPreferences("myprefs", AppCompatActivity.MODE_PRIVATE)
        val usersaved = misPreferencias.getString("user", "")

        binding.nombrehome.text = usersaved

        binding.btCompeticiones.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_competicionesFragment)
        }
    }

}