package com.example.weddingplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.weddingplanner.databinding.ActivityMainBinding
import com.example.weddingplanner.presentation.CategoriesFragment
import com.example.weddingplanner.presentation.HomeFragment
import com.example.weddingplanner.presentation.OnBoardingFragment
import com.example.weddingplanner.presentation.SaveFragment
import com.example.weddingplanner.utilits.APP_ACTIVITY
import com.example.weddingplanner.utilits.replaceFragmentMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        setContentView(binding.root)

        replaceFragmentMain(OnBoardingFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragmentMain(HomeFragment())
                R.id.categories -> replaceFragmentMain(CategoriesFragment())
                R.id.save -> replaceFragmentMain(SaveFragment())

                else -> hideBottomNavigationView()
            }
            true
        }
    }

    fun hideBottomNavigationView() {
        binding.bottomNavigationView.visibility = View.GONE
    }

    fun showBottomNavigationView() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}