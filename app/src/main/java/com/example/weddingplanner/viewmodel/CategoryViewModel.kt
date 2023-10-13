package com.example.weddingplanner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Categories
import com.example.domain.entities.Favorite
import com.example.domain.usecase.category.AllCategoryUseCase
import com.example.domain.usecase.category.InsertCategoryUseCase
import com.example.domain.usecase.category.UpdateCategoryUseCase
import com.example.domain.usecase.favorite.AllFavoritesUseCase
import com.example.domain.usecase.favorite.DeleteFavoritesUseCase
import com.example.domain.usecase.favorite.InsertFavoritesUseCase
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val allCategoryUseCase: AllCategoryUseCase,
    private val insertCategoryUseCase: InsertCategoryUseCase,
    private val updateCategoryUseCase: UpdateCategoryUseCase,
    private val allFavoritesUseCase: AllFavoritesUseCase,
    private val insertFavoritesUseCase: InsertFavoritesUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase)
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

    fun getAllReady2() = viewModelScope.launch {
        allCategoryUseCase.invoke()
            .collect{todo -> todo}
    }

    fun getAllReady() {
        viewModelScope.launch {
            allCategoryUseCase.invoke()
                .collect{todo ->
                    _placeList.value = todo}
        }
    }

    private val _favList = MutableLiveData<List<Favorite>>()
    val favList: LiveData<List<Favorite>> get() = _favList

    fun insertFav(favorite: Favorite) = viewModelScope.launch{
        insertFavoritesUseCase.invoke(favorite = favorite)
    }

    fun deleteFav(favorite: Favorite) = viewModelScope.launch{
        deleteFavoritesUseCase.invoke(favorite = favorite)
    }

    fun getAllFav() {
        viewModelScope.launch {
            allFavoritesUseCase.invoke()
                .collect{todo ->
                    _favList.value = todo}
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