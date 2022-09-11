package com.mostafa.shoesstore.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoeDataModel(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()) : Parcelable

