package com.example.weddingplanner.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weddingplanner.R
import com.example.weddingplanner.databinding.FragmentCategoriesBinding
import com.example.weddingplanner.databinding.FragmentDataBinding
import com.example.weddingplanner.presentation.category.CakeFragment
import com.example.weddingplanner.presentation.category.DressFragment
import com.example.weddingplanner.presentation.category.HomeDecFragment
import com.example.weddingplanner.presentation.category.PlaceFragment
import com.example.weddingplanner.utilits.replaceFragmentMain

class CategoriesFragment : Fragment() {
    private var _binding : FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        binding.catPlace.setOnClickListener { replaceFragmentMain(PlaceFragment()) }

        binding.catCostume.setOnClickListener { replaceFragmentMain(DressFragment())}

        binding.catCake.setOnClickListener { replaceFragmentMain(CakeFragment())  }

        binding.catHome.setOnClickListener { replaceFragmentMain(HomeDecFragment())}

        return binding.root
    }
}