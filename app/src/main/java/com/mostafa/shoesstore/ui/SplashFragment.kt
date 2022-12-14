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
import com.mostafa.shoesstore.databinding.FragmentSplashBinding
import com.mostafa.shoesstore.viewmodel.ShoesViewModel


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val viewModel: ShoesViewModel by activityViewModels()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(binding.root)

        binding.nextBtn.setOnClickListener {
            navController.navigate(R.id.instructionsFragment)
        }

    }


}