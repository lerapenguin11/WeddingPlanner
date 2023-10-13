package com.example.weddingplanner.di

import com.example.weddingplanner.viewmodel.CategoryViewModel
import com.example.weddingplanner.viewmodel.ReadyViewModel
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

    viewModel<ReadyViewModel> {
        ReadyViewModel(
            allReadyUseCase = get(),
            insertReadyUseCase = get(),
            updateReadyUseCase = get()
        )
    }

    viewModel<CategoryViewModel> {
        CategoryViewModel(
            allCategoryUseCase = get(),
            insertCategoryUseCase = get(),
            updateCategoryUseCase = get()
        )
    }
}