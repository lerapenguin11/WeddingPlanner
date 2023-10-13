package com.example.weddingplanner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Ready
import com.example.domain.usecase.ready.AllReadyUseCase
import com.example.domain.usecase.ready.InsertReadyUseCase
import com.example.domain.usecase.ready.UpdateReadyUseCase
import com.example.weddingplanner.R
import kotlinx.coroutines.launch

class ReadyViewModel(
    private val allReadyUseCase: AllReadyUseCase,
    private val insertReadyUseCase: InsertReadyUseCase,
    private val updateReadyUseCase: UpdateReadyUseCase
) : ViewModel() {

    private val _readyList = MutableLiveData<List<Ready>>()
    val readyList: LiveData<List<Ready>> get() = _readyList

    val list : MutableList<Ready> = mutableListOf()

    fun insertReady(ready: List<Ready>) = viewModelScope.launch{
        insertReadyUseCase.invoke(ready = ready)
    }

    fun updateReady(ready: Ready) = viewModelScope.launch{
        updateReadyUseCase.invoke(ready = ready)
    }

    fun getAllReady() {
        viewModelScope.launch {
            allReadyUseCase.invoke()
                .collect{todo ->
                    _readyList.value = todo}
        }
    }

    fun init(){
        val ready1 = Ready(0, "Place", R.drawable.ic_place, false)
        list.add(ready1)

        val ready2 = Ready(1, "Costume", R.drawable.ic_castume, false)
        list.add(ready2)

        val ready3 = Ready(2, "Bouquet", R.drawable.ic_buqect, false)
        list.add(ready3)

        val ready4 = Ready(3, "Cake", R.drawable.ic_cake, false)
        list.add(ready4)
    }
}