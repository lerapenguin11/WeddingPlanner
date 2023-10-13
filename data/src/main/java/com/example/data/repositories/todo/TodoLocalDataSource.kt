package com.example.data.repositories.todo

import com.example.data.entities.Note
import com.example.domain.entities.Todo
import kotlinx.coroutines.flow.Flow

interface TodoLocalDataSource {

    fun getAllNotes() : Flow<List<Todo>>

    suspend fun getInsert(todo: Todo)

    suspend fun getUpdate(todo: Todo)
}