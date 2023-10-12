package com.example.weddingplanner.di

import com.example.domain.usecase.todo.AllNotesUseCase
import com.example.domain.usecase.todo.InsertNotesUseCase
import com.example.domain.usecase.todo.UpdateNoteUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<AllNotesUseCase> { AllNotesUseCase(
        repository = get()
    ) }

    factory<InsertNotesUseCase> {  InsertNotesUseCase(
        repository = get()
    )}

    factory<UpdateNoteUseCase> { UpdateNoteUseCase(
        repository = get()
    ) }
}