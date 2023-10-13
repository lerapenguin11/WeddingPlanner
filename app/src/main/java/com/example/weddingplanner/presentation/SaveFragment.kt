package com.example.weddingplanner.presentation

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
import com.example.weddingplanner.databinding.FragmentDataBinding
import com.example.weddingplanner.databinding.FragmentSaveBinding
import com.example.weddingplanner.presentation.adapter.FavoriteAdapter
import com.example.weddingplanner.presentation.adapter.listener.FavoriteListener
import com.example.weddingplanner.utilits.replaceFragmentMain
import com.example.weddingplanner.viewmodel.CategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SaveFragment : Fragment(), FavoriteListener {
    private var _binding : FragmentSaveBinding? = null
    private val binding get() = _binding!!
    private val favViewModel by viewModel<CategoryViewModel>()
    private val favoriteAdapter = FavoriteAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSaveBinding.inflate(inflater, container, false)

        favViewModel.getAllFav()
        binding.rvFav.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvFav.adapter = favoriteAdapter

        favViewModel.favList.observe(viewLifecycleOwner, Observer {
            favoriteAdapter.setItem(it)
        })

        return binding.root
    }

    override fun getFavoriteListener(fav: Favorite) {
        favViewModel.deleteFav(favorite = fav)
        favViewModel.updatePlace(Categories(id = fav.id, icon = fav.icon, isCompleted = false))
    }
}