package com.example.domain.usecase.favorite

import com.example.domain.entities.Favorite
import com.example.domain.entities.Ready
import com.example.domain.repository.FavoriteRepository

class InsertFavoritesUseCase(private val repository: FavoriteRepository) {

    suspend operator fun invoke(favorite : Favorite) = repository.insertFavorite(favorite = favorite)
}