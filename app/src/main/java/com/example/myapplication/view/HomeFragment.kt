package com.example.myapplication.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import com.example.myapplication.databinding.HomeFragmentBinding
import com.example.myapplication.viewmodel.ShoeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding : HomeFragmentBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater)
//        binding.shoe = viewModel.shoe

        setHasOptionsMenu(true)

//        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        viewModel.shoeList.observe(requireActivity(), Observer { shoeList->
            Log.e("shoe",shoeList.size.toString())
            for (i in shoeList.indices){
                addViews(shoeList[i].name ,
                    shoeList[i].company ,
                    shoeList[i].size.toString() ,
                    shoeList[i].description)
            }


        })

        binding.btnAdd.setOnClickListener { View->

            view?.findNavController()?.navigate(R.id.action_homeFragment_to_detailsFragment)

        }
        return binding.root
    }

    fun addViews(txName : String, txCompany : String , txSize : String, txDescription :String ){
        val name = TextView(context)
        name.text = txName
        name.textColors
        name.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_500));
        name.gravity = Gravity.CENTER_HORIZONTAL
        name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 20)
        name.layoutParams = params


        val company = TextView(context)
        company.text = txCompany
        company.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_500));
        company.gravity = Gravity.CENTER_HORIZONTAL
        company.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)

        params.setMargins(0, 20, 0, 20)
        company.layoutParams = params

        val size = TextView(context)
        size.text = txSize
        size.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_500));
        size.gravity = Gravity.CENTER_HORIZONTAL
        size.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)

        params.setMargins(0, 20, 0, 20)
        size.layoutParams = params

        val description = TextView(context)
        description.text = txDescription
        description.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_500));
        description.gravity = Gravity.CENTER_HORIZONTAL
        description.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)

        params.setMargins(0, 20, 0, 20)
        description.layoutParams = params


        val line = View(context)
        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 12)
        layoutParams.setMargins(0,0,0,20)
        line.layoutParams = layoutParams
        line.background = ContextCompat.getDrawable(requireContext(), R.drawable.gredient_gray);

        binding.baseLinear.addView(name)
        binding.baseLinear.addView(company)
        binding.baseLinear.addView(size)
        binding.baseLinear.addView(description)
        binding.baseLinear.addView(line)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}