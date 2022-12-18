package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.DetailsFragmentBinding
import com.example.myapplication.viewmodel.ShoeViewModel

class DetailsFragment : Fragment() {
    private lateinit var binding : DetailsFragmentBinding
    private  val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(layoutInflater)
        binding.shoe = viewModel.shoe
      clickListeners()

        return binding.root
    }


    private fun clickListeners(){
        binding.btnSave.setOnClickListener { View ->
            if (binding.edtName.text.toString().isEmpty()||binding.edtCompany.text.toString().isEmpty()||
                binding.edtDescription.text.toString().isEmpty()||binding.edtSize.text.toString().isEmpty()){
                Toast.makeText(context,"please fill fields",Toast.LENGTH_LONG).show()
            }
            else{
                viewModel.addShoe()
//                viewModel.addShoe (binding.edtName.text.toString()
//                    ,binding.edtSize.text.toString().toDouble()
//                    , binding.edtCompany.text.toString() ,
//                    binding.edtDescription.text.toString()
//                    ,"" )

                findNavController().navigateUp()
            }

        }

        binding.btnCancel.setOnClickListener { View ->
            findNavController().navigateUp()
        }
    }
}