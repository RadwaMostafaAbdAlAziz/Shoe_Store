package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {
    private lateinit var binding: InstructionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InstructionFragmentBinding.inflate(layoutInflater)

        clickListeners()

        return binding.root
    }

    private fun clickListeners() {

        binding.btnNext.setOnClickListener { View ->
            view?.findNavController()?.navigate(R.id.action_instructionFragment_to_homeFragment)
        }
    }

}