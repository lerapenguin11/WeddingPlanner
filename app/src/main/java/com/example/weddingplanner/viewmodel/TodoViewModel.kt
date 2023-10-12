package com.example.weddingplanner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Todo
import com.example.domain.usecase.todo.AllNotesUseCase
import com.example.domain.usecase.todo.InsertNotesUseCase
import com.example.domain.usecase.todo.UpdateNoteUseCase
import kotlinx.coroutines.launch

class TodoViewModel(
    private val getAllNotesUseCase: AllNotesUseCase,
    private val insertNotesUseCase: InsertNotesUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase)
    : ViewModel(){

    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> get() = _todoList

    fun insertTodo(todo: Todo) = viewModelScope.launch{
        insertNotesUseCase.invoke(todo = todo)
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch{
        updateNoteUseCase.invoke(todo = todo)
    }

    fun getAllTodo() {
        viewModelScope.launch {
            getAllNotesUseCase.invoke()
                .collect{todo ->
                    _todoList.value = todo}
        }
    }
}