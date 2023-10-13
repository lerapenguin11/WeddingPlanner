package com.example.weddingplanner.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    val sharedPreferences : SharedPreferences = application.getSharedPreferences("pref_pofile", Context.MODE_PRIVATE)

    val codeSher : SharedPreferences = application.getSharedPreferences("pref_pofile", Context.MODE_PRIVATE)

    fun registerUser(name: String, date: String, code : Int) {
        sharedPreferences.edit().apply {
            putString("name", name)
            putString("date", date)
            apply()
        }
        codeSher.edit().apply {
            putInt("code", code)
            apply()
        }
    }
}