package com.example.data.repositories.favorite

import com.example.data.db.FavoriteDao
import com.example.data.mappers.FavoriteEntityMapper
import com.example.domain.entities.Favorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class FavoriteLocalDataSourceImpl(
    private val favoriteDao: FavoriteDao,
    private val favoriteEntityMapper: FavoriteEntityMapper)
    : FavoriteLocalDataSource {

    override fun getAllFavorite(): Flow<List<Favorite>> {
        val favoriteFlow = favoriteDao.getAllFavorites()

        return favoriteFlow.map { list ->
            list.map { element ->
                favoriteEntityMapper.toFavorite(element)
            }
        }
    }

    override suspend fun getInsertFavorite(favorite: Favorite) {
        withContext(Dispatchers.IO){
            favoriteDao.insertFavorite(favoriteEntityMapper.toFavoriteEntity(favorite  = favorite))
        }
    }

    override suspend fun getDeleteFavorite(favorite: Favorite) {
        withContext(Dispatchers.IO){
            favoriteDao.deleteFavorite(favoriteEntityMapper.toFavoriteEntity(favorite = favorite))
        }
    }
}