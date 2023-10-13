package com.example.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val icon : String,
    val isCompleted: Boolean
)
