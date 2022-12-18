package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding
//    private var isEmpty = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater)

        clickListeners()
        return binding.root
    }

    private fun clickListeners() {

            binding.btnLogin.setOnClickListener { View ->
                if (binding.edtEmail.text.isEmpty() || binding.edtPassword.text.isEmpty()) {
                    Toast.makeText(context, "please fill fields", Toast.LENGTH_LONG).show()
                } else {
                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_welcomeFragment2)
                }
            }
            binding.btnRegister.setOnClickListener { View ->
                if (binding.edtEmail.text.isEmpty() || binding.edtPassword.text.isEmpty()) {
                    Toast.makeText(context, "please fill fields", Toast.LENGTH_LONG).show()
                } else {
                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_welcomeFragment2)
                }
            }
//        if (!isEmpty){
//            binding.btnLogin.setOnClickListener { View ->
//                view?.findNavController()?.navigate(R.id.action_loginFragment_to_welcomeFragment2)
//            }
//            binding.btnRegister.setOnClickListener { View ->
//                view?.findNavController()?.navigate(R.id.action_loginFragment_to_welcomeFragment2)
//            }
//        }
    }

//    private fun isEmpty() {
//        if (binding.edtEmail.text.toString() == "" || binding.edtPassword.text.toString() == "") {
//            Toast.makeText(context, "please fill fields", Toast.LENGTH_LONG).show()
//        } else {
//            isEmpty = false
//        }
//    }
}