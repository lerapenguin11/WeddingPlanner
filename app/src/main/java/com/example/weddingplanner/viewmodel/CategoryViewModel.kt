package com.example.weddingplanner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Categories
import com.example.domain.entities.Ready
import com.example.domain.usecase.category.AllCategoryUseCase
import com.example.domain.usecase.category.InsertCategoryUseCase
import com.example.domain.usecase.category.UpdateCategoryUseCase
import com.example.weddingplanner.R
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val allCategoryUseCase: AllCategoryUseCase,
    private val insertCategoryUseCase: InsertCategoryUseCase,
    private val updateCategoryUseCase: UpdateCategoryUseCase)
    : ViewModel(){

    private val _placeList = MutableLiveData<List<Categories>>()
    val placeList: LiveData<List<Categories>> get() = _placeList

    val list : MutableList<Categories> = mutableListOf()

    fun insertPlace(ready: List<Categories>) = viewModelScope.launch{
        insertCategoryUseCase.invoke(category = ready)
    }

    fun updatePlace(ready: Categories) = viewModelScope.launch{
        updateCategoryUseCase.invoke(categories = ready)
    }

    fun getAllReady() {
        viewModelScope.launch {
            allCategoryUseCase.invoke()
                .collect{todo ->
                    _placeList.value = todo}
        }
    }

    fun initPlace(){
        val ready1 = Categories(0, "https://avon-wish.ru/wp-content/uploads/6/8/9/689baca969cd7c094e296ac775c43066.jpeg", false)
        list.add(ready1)

        val ready2 = Categories(1, "https://avon-wish.ru/wp-content/uploads/6/8/9/689baca969cd7c094e296ac775c43066.jpeg", false)
        list.add(ready2)

        val ready3 = Categories(2, "https://avon-wish.ru/wp-content/uploads/6/8/9/689baca969cd7c094e296ac775c43066.jpeg", false)
        list.add(ready3)

        val ready4 = Categories(3, "https://o-tendencii.com/uploads/posts/2022-02/1645679812_20-o-tendencii-com-p-tort-na-svadbu-odnoyarusnii-kremovii-foto-20.jpg", false)
        list.add(ready4)
    }

}