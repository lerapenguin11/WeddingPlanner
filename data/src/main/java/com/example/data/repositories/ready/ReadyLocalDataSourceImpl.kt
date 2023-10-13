package com.example.data.repositories.ready

import com.example.data.db.ReadyDao
import com.example.data.mappers.ReadyEntityMapper
import com.example.domain.entities.Ready
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ReadyLocalDataSourceImpl(
    private val readyDao: ReadyDao,
    private val readyEntityMapper: ReadyEntityMapper) : ReadyLocalDataSource{
    override fun getAllNotes(): Flow<List<Ready>> {
        val readyFlow = readyDao.getAllReady()

        return readyFlow.map { list ->
            list.map { element ->
                readyEntityMapper.toReady(element)
            }
        }
    }

    override suspend fun getInsert(ready: List<Ready>) {
        withContext(Dispatchers.IO){
            readyDao.insert(readyEntityMapper.toReadyEntityList(ready  = ready))
        }
    }

    override suspend fun getUpdate(ready: Ready) {
        withContext(Dispatchers.IO){
            readyDao.update(readyEntityMapper.toReadyEntity(ready = ready))
        }
    }
}