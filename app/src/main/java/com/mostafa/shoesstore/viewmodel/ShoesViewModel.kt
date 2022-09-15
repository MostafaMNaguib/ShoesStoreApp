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

    fun addNewShoe(){
        _shoesDataList.value!!.add(
            ShoeDataModel(newShoeName,newShoeSize.toDouble(),newShoeCompany,newShoeDescription)
        )
        Log.e("ShoesViewModel", "addNewShoe: ${shoesDataList.value}" )
        Timber.e( "addNewShoe: $shoesDataList " )
    }

    private fun addFakeShoesData(){
        _shoesDataList.value!!.add(
            ShoeDataModel("Shoe", 7.0, "Company ", "Shoe Desc")
        )
    }

    fun checkInputValidation():Boolean{

        if (
            newShoeName.isBlank()||
            newShoeCompany.isBlank()||
            newShoeSize.isBlank()||
            newShoeDescription.isBlank()
        ){
            return false
        }
        return true

    }


}