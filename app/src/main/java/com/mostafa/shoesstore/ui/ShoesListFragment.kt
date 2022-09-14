package com.mostafa.shoesstore.ui

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.VISIBLE
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mostafa.shoesstore.R
import com.mostafa.shoesstore.data.models.ShoeDataModel
import com.mostafa.shoesstore.databinding.FragmentShoesListBinding
import com.mostafa.shoesstore.viewmodel.ShoesViewModel
import timber.log.Timber


class ShoesListFragment : Fragment() {

    private lateinit var binding: FragmentShoesListBinding
    private val viewModel: ShoesViewModel by activityViewModels()
    private lateinit var navController: NavController
    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoesListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)
        mContext = binding.root.context

        binding.addNewShoeBtn.setOnClickListener {
            navController.navigate(R.id.addNewShoeFragment)
        }


        viewModel.shoesDataList.observe(viewLifecycleOwner){

            Timber.e( "onViewCreated: ${it.size} ")
            binding.shoesList.removeAllViews()
            for (shoe in it){
                fillShoeList(shoe)
            }
        }

        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_logout->{
                navController.navigate(R.id.actionLogout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun fillShoeList(shoe: ShoeDataModel)
    {
        val textView = TextView(mContext).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 20, 0, 0)
                setPadding(10, 10, 0, 10)
            }
            text = shoe.name
            setTextColor(resources.getColor( R.color.black))
            textSize = 16.0f
            typeface = Typeface.defaultFromStyle(Typeface.BOLD)
        }
        val linearLayout = binding.shoeItem
        linearLayout.addView(textView)
    }


}