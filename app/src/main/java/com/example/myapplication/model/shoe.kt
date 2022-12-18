package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Shoe(
    var name: String = "", var size: Double? = null, var company: String = "", var description: String = "",
                var image: String = "") : Parcelable