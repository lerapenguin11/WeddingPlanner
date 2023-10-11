package com.example.weddingplanner.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weddingplanner.presentation.DetailFragment
import com.example.weddingplanner.presentation.PlanningFragment

class HomePagerAdapter(
    fragment : FragmentManager,
    lifecycle : Lifecycle
) : FragmentStateAdapter(fragment, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0){
            PlanningFragment()
        } else DetailFragment()
    }
}