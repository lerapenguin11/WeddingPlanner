package com.example.domain.repository

import com.example.domain.entities.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getAllNotes() : Flow<List<Todo>>

    suspend fun getInsert(todo: Todo)

    suspend fun getUpdate(todo: Todo)
}