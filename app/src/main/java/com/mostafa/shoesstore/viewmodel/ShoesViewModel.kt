package com.mostafa.shoesstore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mostafa.shoesstore.data.models.ShoeDataModel

class ShoesViewModel:ViewModel()
{

    private val _shoesDataList = MutableLiveData<MutableList<ShoeDataModel>>()
    val shoesDataList : LiveData<MutableList<ShoeDataModel>>
    get() = _shoesDataList



    init {
        _shoesDataList.value = mutableListOf()
    }




}