package com.example.wikifutbol2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wikifutbol2.databinding.CompeticionesLayoutBinding

class CompeticionesFragment : Fragment() {

    private lateinit var binding: CompeticionesLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CompeticionesLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}

