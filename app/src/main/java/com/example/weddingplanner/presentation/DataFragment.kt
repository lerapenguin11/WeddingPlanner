package com.example.weddingplanner.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weddingplanner.MainActivity
import com.example.weddingplanner.R
import com.example.weddingplanner.databinding.FragmentDataBinding
import com.example.weddingplanner.databinding.FragmentOnBoardingBinding
import com.example.weddingplanner.utilits.replaceFragmentMain

class DataFragment : Fragment() {
    private var _binding : FragmentDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDataBinding.inflate(inflater, container, false)

        binding.btBtNext.setOnClickListener { replaceFragmentMain(HomeFragment()) }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).hideBottomNavigationView()
    }
}