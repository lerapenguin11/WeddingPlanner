package com.example.data.repositories.todo

import com.example.data.repositories.todo.TodoLocalDataSource
import com.example.domain.entities.Todo
import com.example.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val localDataSource: TodoLocalDataSource
) : TodoRepository{

    override fun getAllNotes(): Flow<List<Todo>> {
        return localDataSource.getAllNotes()
    }

    override suspend fun getInsert(todo: Todo) {
        localDataSource.getInsert(todo = todo)
    }

    override suspend fun getUpdate(todo: Todo) {
        localDataSource.getUpdate(todo = todo)
    }
}