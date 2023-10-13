package com.example.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ready")
data class ReadyEntity(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val text: String,
    val icon : Int,
    val isCompleted: Boolean
)
