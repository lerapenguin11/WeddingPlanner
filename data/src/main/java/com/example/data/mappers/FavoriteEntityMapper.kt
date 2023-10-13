package com.example.data.mappers

import com.example.data.entities.FavoriteEntity
import com.example.data.entities.Note
import com.example.domain.entities.Favorite
import com.example.domain.entities.Todo

class FavoriteEntityMapper {

    fun toFavoriteEntity(favorite: Favorite): FavoriteEntity {
        return FavoriteEntity(
            id = favorite.id,
            isCompleted = favorite.isCompleted,
            icon = favorite.icon
        )
    }

    fun toFavorite(favorite: FavoriteEntity): Favorite {
        return Favorite(
            id = favorite.id,
            isCompleted = favorite.isCompleted,
            icon = favorite.icon
        )
    }
}