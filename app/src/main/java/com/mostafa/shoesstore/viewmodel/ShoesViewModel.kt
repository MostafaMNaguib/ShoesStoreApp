package com.mostafa.shoesstore.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mostafa.shoesstore.data.models.ShoeDataModel
import timber.log.Timber

class ShoesViewModel:ViewModel()
{

    private val _shoesDataList = MutableLiveData<MutableList<ShoeDataModel>>()
    val shoesDataList : LiveData<MutableList<ShoeDataModel>>
    get() = _shoesDataList

    var newShoeName = ""
    var newShoeCompany = ""
    var newShoeSize = ""
    var newShoeDescription = ""

    init {
        Log.e("ShoesViewModel", "ViewModel: ")
        _shoesDataList.value = mutableListOf()
        addFakeShoesData()
    }

    fun addNewShoe(shoe: ShoeDataModel){
        _shoesDataList.value!!.add(shoe)
        Log.e("ShoesViewModel", "addNewShoe: ${shoesDataList.value}" )
        Timber.e( "addNewShoe: $shoesDataList " )
    }

    private fun addFakeShoesData(){
        addNewShoe(ShoeDataModel("Shoe", 7.0, "Company ", "Shoe Desc"))
    }


}