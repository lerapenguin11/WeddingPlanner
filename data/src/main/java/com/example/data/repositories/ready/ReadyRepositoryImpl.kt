package com.example.data.repositories.ready

import com.example.domain.entities.Ready
import com.example.domain.repository.ReadyRepository
import kotlinx.coroutines.flow.Flow

class ReadyRepositoryImpl(
    private val localDataSource: ReadyLocalDataSource)
    : ReadyRepository {

    override fun getAllReady(): Flow<List<Ready>> {
        return localDataSource.getAllNotes()
    }

    override suspend fun getInsert(ready: List<Ready>) {
        localDataSource.getInsert(ready = ready)
    }

    override suspend fun getUpdate(ready: Ready) {
        localDataSource.getUpdate(ready = ready)
    }
}