package com.example.domain.usecase.todo

import com.example.domain.entities.Todo
import com.example.domain.repository.TodoRepository

class InsertNotesUseCase(private val repository: TodoRepository) {

    suspend operator fun invoke(todo: Todo) = repository.getInsert(todo = todo)
}