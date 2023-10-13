package com.example.domain.usecase.favorite

import com.example.domain.repository.FavoriteRepository

class AllFavoritesUseCase(private val repository: FavoriteRepository) {

    operator fun invoke() = repository.getAllFavorites()
}