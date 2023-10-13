package com.example.data.repositories.favorite

import com.example.domain.entities.Favorite
import com.example.domain.entities.Ready
import kotlinx.coroutines.flow.Flow

interface FavoriteLocalDataSource{

    fun getAllFavorite() : Flow<List<Favorite>>

    suspend fun getInsertFavorite(favorite : Favorite)

    suspend fun getDeleteFavorite(favorite : Favorite)
}
