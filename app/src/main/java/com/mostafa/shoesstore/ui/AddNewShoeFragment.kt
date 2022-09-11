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



    }

}