package com.example.weddingplanner.presentation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.example.weddingplanner.R
import com.example.weddingplanner.databinding.ActivityMainBinding
import com.example.weddingplanner.utilits.APP_ACTIVITY
import com.example.weddingplanner.utilits.replaceFragmentMain
import com.example.weddingplanner.viewmodel.RegistrationViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/

        val code = viewModel.codeSher.getInt("code", 0)
        if (code == 1){
            replaceFragmentMain(HomeFragment())
            binding.bottomNavigationView.setOnItemSelectedListener {

                when(it.itemId){
                    R.id.home -> replaceFragmentMain(HomeFragment())
                    R.id.categories -> replaceFragmentMain(CategoriesFragment())
                    R.id.save -> replaceFragmentMain(SaveFragment())

                    else -> hideBottomNavigationView()
                }
                true
            }
        } else{
            replaceFragmentMain(OnBoardingFragment())
        }
    }

    fun hideBottomNavigationView() {
        binding.bottomNavigationView.visibility = View.GONE
    }

    fun showBottomNavigationView() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}