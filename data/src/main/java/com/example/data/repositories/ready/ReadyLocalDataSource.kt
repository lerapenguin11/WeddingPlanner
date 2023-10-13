package com.example.data.repositories.ready

import com.example.domain.entities.Ready
import kotlinx.coroutines.flow.Flow

interface ReadyLocalDataSource {

    fun getAllNotes() : Flow<List<Ready>>

    suspend fun getInsert(ready: List<Ready>)

    suspend fun getUpdate(ready: Ready)
}