package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WelcomeFragmentBinding.inflate(layoutInflater)

        clickListeners()

        return binding.root
    }

    private fun clickListeners() {

        binding.btnNext.setOnClickListener { View ->
                view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_instructionFragment)
            }
    }
}