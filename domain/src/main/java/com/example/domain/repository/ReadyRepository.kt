package com.example.domain.repository

import com.example.domain.entities.Ready
import kotlinx.coroutines.flow.Flow

interface ReadyRepository {

    fun getAllReady() : Flow<List<Ready>>

    suspend fun getInsert(ready: List<Ready>)

    suspend fun getUpdate(ready: Ready)
}