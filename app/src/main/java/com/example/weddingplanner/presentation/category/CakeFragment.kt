package com.example.weddingplanner.presentation.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entities.Categories
import com.example.domain.entities.Favorite
import com.example.weddingplanner.R
import com.example.weddingplanner.databinding.FragmentCakeBinding
import com.example.weddingplanner.databinding.FragmentDressBinding
import com.example.weddingplanner.presentation.CategoriesFragment
import com.example.weddingplanner.presentation.adapter.CategoryAdapter
import com.example.weddingplanner.presentation.adapter.listener.CategoryListener
import com.example.weddingplanner.utilits.replaceFragmentMain
import com.example.weddingplanner.viewmodel.CategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CakeFragment : Fragment(), CategoryListener {
    private var _binding : FragmentCakeBinding? = null
    private val binding get() = _binding!!
    private val placeViewModel by viewModel<CategoryViewModel>()
    private val placeAdapter = CategoryAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCakeBinding.inflate(inflater, container, false)

        placeViewModel.getAllReady()
        binding.rvPlace.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvPlace.adapter = placeAdapter
        placeViewModel.placeList.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()){
                placeViewModel.initPlace()
                placeViewModel.insertPlace(placeViewModel.list)

                val filteredList = placeViewModel.list.filter { category ->
                    category.id in 12..17
                }

                placeAdapter.setItem(filteredList)
            } else{
                val filteredList = it.filter { category ->
                    category.id in 12..17

                }

                placeAdapter.setItem(filteredList)
            }
        })

        binding.icArrow.setOnClickListener { replaceFragmentMain(CategoriesFragment()) }


        return binding.root
    }

    override fun getCategoryListener(categories: Categories) {
        if (categories.isCompleted){
            placeViewModel.updatePlace(Categories(id = categories.id, icon = categories.icon, isCompleted = false))
            placeViewModel.deleteFav(Favorite(id = categories.id, icon = categories.icon, isCompleted = false))
        }else{
            placeViewModel.updatePlace(Categories(id = categories.id, icon = categories.icon, isCompleted = true))
            placeViewModel.insertFav(Favorite(id = categories.id, icon = categories.icon, isCompleted = true))
        }
    }
}