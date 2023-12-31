package com.example.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note (
        @PrimaryKey(autoGenerate = false)
        val id: Int = 0,
        val text: String,
        val isCompleted: Boolean
)