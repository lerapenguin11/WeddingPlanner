package com.example.data.repositories.favorite

import com.example.domain.entities.Favorite
import com.example.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl(
    private val localDataSource: FavoriteLocalDataSource
) : FavoriteRepository{

    override fun getAllFavorites(): Flow<List<Favorite>> {
        return localDataSource.getAllFavorite()
    }

    override suspend fun insertFavorite(favorite: Favorite) {
        localDataSource.getInsertFavorite(favorite = favorite)
    }

    override suspend fun deleteFavorite(favorite: Favorite) {
        localDataSource.getDeleteFavorite(favorite = favorite)
    }
}