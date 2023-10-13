package com.example.weddingplanner.presentation.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entities.Categories
import com.example.weddingplanner.databinding.FragmentPlaceBinding
import com.example.weddingplanner.presentation.adapter.CategoryAdapter
import com.example.weddingplanner.viewmodel.CategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaceFragment : Fragment() {
    private var _binding : FragmentPlaceBinding? = null
    private val binding get() = _binding!!
    private val placeViewModel by viewModel<CategoryViewModel>()
    private val placeAdapter = CategoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlaceBinding.inflate(inflater, container, false)

        placeViewModel.getAllReady()
        binding.rvPlace.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvPlace.adapter = placeAdapter
        placeViewModel.placeList.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()){
                placeViewModel.initPlace()
                placeViewModel.insertPlace(placeViewModel.list)

                val filteredList = placeViewModel.list.filter { category ->
                    category.id in 0..2
                }

                placeAdapter.setItem(filteredList)
            } else{
                placeViewModel.getAllReady()
                val filteredList = it.filter { category ->
                    category.id in 0..2

                }

                placeAdapter.setItem(filteredList)
            }
        })


        return binding.root
    }
}