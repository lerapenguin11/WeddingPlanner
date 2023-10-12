package com.example.weddingplanner.di

import com.example.weddingplanner.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<TodoViewModel> {
        TodoViewModel(
            getAllNotesUseCase = get(),
            insertNotesUseCase = get(),
            updateNoteUseCase = get()
        )
    }
}