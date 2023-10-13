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

        val ready2 = Categories(1, "https://mia-bags.ru/wp-content/uploads/6/7/c/67cce8e47e80a330afe5ddfb0adadcf5.jpeg", false)
        list.add(ready2)

        val ready3 = Categories(2, "https://mykaleidoscope.ru/x/uploads/posts/2023-05/1684910441_mykaleidoscope-ru-p-pryamie-volosi-na-svadbu-krasivo-55.jpg", false)
        list.add(ready3)

        val ready4 = Categories(3, "https://almode.ru/uploads/posts/2022-02/1646061632_63-almode-ru-p-prichyoski-na-bal-dlya-devochek-65.jpg", false)
        list.add(ready4)

        val ready5 = Categories(4, "https://lavali.ru/wp-content/uploads/2/1/6/21674ef43af45c6e257864617ff65515.jpeg", false)
        list.add(ready5)

        val ready6 = Categories(5, "https://allsisters.ru/wp-content/uploads/f/4/4/f44ce8b220e41c83e1b017fc4f9ccba2.jpeg", false)
        list.add(ready6)
//
        val ready7 = Categories(6, "https://even-st.ru/wp-content/uploads/a/d/a/adab0e08efa41e21c6d6b758ad1bae22.jpeg", false)
        list.add(ready7)

        val ready8 = Categories(7, "https://mykaleidoscope.ru/uploads/posts/2022-06/1655863800_51-mykaleidoscope-ru-p-samie-krasivie-platya-na-svadbu-krasivo-fo-55.jpg", false)
        list.add(ready8)

        val ready9 = Categories(8, "https://tytsvadba.ru/wp-content/uploads/2022/11/stili-svadebnyh-platev-66.jpg", false)
        list.add(ready9)

        val ready10 = Categories(9, "https://mykaleidoscope.ru/uploads/posts/2023-05/1685170640_mykaleidoscope-ru-p-svadebnie-platya-dlya-zagsa-3.jpg", false)
        list.add(ready10)

        val ready11 = Categories(10, "https://almode.ru/uploads/posts/2020-08/1596286420_33-p-kartinki-svadebnikh-platev-47.jpg", false)
        list.add(ready11)

        val ready12 = Categories(11, "https://mykaleidoscope.ru/uploads/posts/2022-06/1655818427_69-mykaleidoscope-ru-p-sovremennie-svadebnie-platya-krasivo-foto-72.jpg", false)
        list.add(ready12)

        //

        val ready13 = Categories(12, "https://mykaleidoscope.ru/uploads/posts/2023-05/1684617039_mykaleidoscope-ru-p-tort-na-olovyannuyu-svadbu-pinterest-68.jpg", false)
        list.add(ready13)

        val ready14 = Categories(13, "https://prixoxo.ru/uploads/posts/2022-09/prixoxo.ru_foto-idei-svadebnogo-torta-1.jpg", false)
        list.add(ready14)

        val ready15 = Categories(14, "https://o-tendencii.com/uploads/posts/2022-02/1645679812_20-o-tendencii-com-p-tort-na-svadbu-odnoyarusnii-kremovii-foto-20.jpg", false)
        list.add(ready15)

        val ready16 = Categories(15, "http://klublady.ru/uploads/posts/2022-02/1644529934_1-klublady-ru-p-originalnie-svadebnie-torti-foto-1.jpg", false)
        list.add(ready16)

        val ready17 = Categories(16, "https://mykaleidoscope.ru/x/uploads/posts/2023-05/1684862612_mykaleidoscope-ru-p-stilnii-tort-na-svadbu-krasivo-78.jpg", false)
        list.add(ready17)

        val ready18 = Categories(17, "https://almode.ru/uploads/posts/2021-02/1613741778_8-p-modnie-svadebnie-torti-8.jpg", false)
        list.add(ready18)
//
        val ready19 = Categories(18, "https://mykaleidoscope.ru/uploads/posts/2021-11/thumbs/1636783235_48-mykaleidoscope-ru-p-ukrashenie-komnati-nevesti-devushka-krasiv-54.jpg", false)
        list.add(ready19)

        val ready20 = Categories(19, "https://i.pinimg.com/originals/3b/f1/c4/3bf1c4303dc42fca50da1ba882b503a0.jpg", false)
        list.add(ready20)

        val ready21 = Categories(20, "https://i.pinimg.com/originals/55/ba/d6/55bad61ed09bd7686b5b46ddbdfb8405.jpg", false)
        list.add(ready21)

        val ready22 = Categories(21, "https://mykaleidoscope.ru/uploads/posts/2022-06/1655829023_36-mykaleidoscope-ru-p-idei-svadebnogo-dekora-krasivo-foto-36.jpg", false)
        list.add(ready22)

        val ready23 = Categories(22, "https://mykaleidoscope.ru/uploads/posts/2021-12/1640270359_52-mykaleidoscope-ru-p-dekor-svadbi-svadba-56.jpg", false)
        list.add(ready23)

        val ready24 = Categories(23, "https://mykaleidoscope.ru/uploads/posts/2022-06/1655829064_74-mykaleidoscope-ru-p-idei-svadebnogo-dekora-krasivo-foto-76.jpg", false)
        list.add(ready24)
    }

}