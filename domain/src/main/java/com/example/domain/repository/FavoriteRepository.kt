package com.example.domain.repository

import com.example.domain.entities.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun getAllFavorites(): Flow<List<Favorite>>

    suspend fun insertFavorite(favorite: Favorite)

    suspend fun deleteFavorite(favorite: Favorite)
}