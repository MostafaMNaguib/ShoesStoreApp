package com.mostafa.shoesstore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mostafa.shoesstore.R
import com.mostafa.shoesstore.data.models.ShoeDataModel
import com.mostafa.shoesstore.databinding.FragmentAddNewShoeBinding
import com.mostafa.shoesstore.viewmodel.ShoesViewModel


class AddNewShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddNewShoeBinding
    private lateinit var navController: NavController
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewShoeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)

        binding.nextBtn.setOnClickListener {
            addShoe()
        }

        binding.cancelBtn.setOnClickListener {
            navController.navigate(R.id.actionAddShoe)
        }

    }

    private fun addShoe(){

        val shoeName = binding.shoeNameEt.text.toString()
        val shoeCompany = binding.shoeCompanyEt.text.toString()
        val shoeDescription = binding.shoeDescriptionEt.text.toString()
        val shoeSize = binding.shoeSizeEt.text.toString()

        if (shoeName.isNotEmpty()&&
            shoeCompany.isNotEmpty()&&
            shoeDescription.isNotEmpty()&&
            shoeSize.isNotEmpty()){
            viewModel.addNewShoe(ShoeDataModel(shoeName,shoeSize.toDouble(),shoeCompany,shoeDescription))
            binding.shoeNameEt.setText("")
            binding.shoeCompanyEt.setText("")
            binding.shoeDescriptionEt.setText("")
            binding.shoeSizeEt.setText("")
            navController.navigate(R.id.actionAddShoe)
        }else{
            if (shoeName.isEmpty()){
                binding.shoeNameEt.error = "Name is required"
            }

            if (shoeCompany.isEmpty()){
                binding.shoeCompanyEt.error = "Company is required"
            }

            if (shoeName.isEmpty()){
                binding.shoeSizeEt.error = "Size is required"
            }

            if (shoeName.isEmpty()){
                binding.shoeDescriptionEt.error = "Description is required"
            }

        }

    }



}