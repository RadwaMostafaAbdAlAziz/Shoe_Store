package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Shoe

class ShoeViewModel : ViewModel() {

    var shoe = Shoe()

    private val list = ArrayList<Shoe>()

    var shoeList = MutableLiveData<List<Shoe>>()

    fun addShoe (name : String ,size : Double , company : String ,describtion : String ,image : String){
        shoe = Shoe(name,size,company,describtion,image)
        Log.e("inViewModel",shoe.toString())
        list.add(Shoe(name,size,company,describtion,image))
        shoeList.value = list
        Log.e("inViewModel",shoeList.value.toString())

    }


}