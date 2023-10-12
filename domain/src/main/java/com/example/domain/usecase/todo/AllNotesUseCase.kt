package com.example.domain.usecase.todo

import com.example.domain.entities.Todo
import com.example.domain.repository.TodoRepository

class AllNotesUseCase(private val repository : TodoRepository) {

    suspend operator fun invoke() = repository.getAllNotes()
}