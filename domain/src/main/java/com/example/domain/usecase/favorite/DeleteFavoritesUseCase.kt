package com.example.domain.usecase.favorite

import com.example.domain.entities.Favorite
import com.example.domain.repository.FavoriteRepository

class DeleteFavoritesUseCase(private val repository: FavoriteRepository) {

    suspend operator fun invoke(favorite: Favorite) = repository.deleteFavorite(favorite = favorite)
}