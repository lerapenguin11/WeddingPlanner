package com.example.weddingplanner.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.weddingplanner.databinding.FragmentDataBinding
import com.example.weddingplanner.utilits.replaceFragmentMain
import com.example.weddingplanner.viewmodel.RegistrationViewModel

class DataFragment : Fragment() {
    private var _binding : FragmentDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDataBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(RegistrationViewModel::class.java)


        binding.btBtNext.setOnClickListener {
            val name = binding.etEnterName.text.toString()
            val surName = binding.etEnterDate.text.toString()
            if (name.isEmpty() && surName.isEmpty()){
                Toast.makeText(context, "Fill in all the fields!", Toast.LENGTH_SHORT).show()
            } else{
                viewModel.registerUser(name, surName, 1)
                //replaceFragmentMain(HomeFragment())
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).hideBottomNavigationView()
    }
}