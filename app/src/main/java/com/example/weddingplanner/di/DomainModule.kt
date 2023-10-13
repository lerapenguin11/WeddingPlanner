package com.example.weddingplanner.di

import com.example.domain.usecase.category.AllCategoryUseCase
import com.example.domain.usecase.category.InsertCategoryUseCase
import com.example.domain.usecase.category.UpdateCategoryUseCase
import com.example.domain.usecase.favorite.AllFavoritesUseCase
import com.example.domain.usecase.favorite.DeleteFavoritesUseCase
import com.example.domain.usecase.favorite.InsertFavoritesUseCase
import com.example.domain.usecase.ready.AllReadyUseCase
import com.example.domain.usecase.ready.InsertReadyUseCase
import com.example.domain.usecase.ready.UpdateReadyUseCase
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

    factory<AllReadyUseCase> { AllReadyUseCase(
        repository = get()
    ) }

    factory<InsertReadyUseCase> {  InsertReadyUseCase(
        repository = get()
    )}

    factory<UpdateReadyUseCase> { UpdateReadyUseCase(
        repository = get()
    ) }

    factory<AllCategoryUseCase> { AllCategoryUseCase(
        repository = get()
    ) }

    factory<InsertCategoryUseCase> {  InsertCategoryUseCase(
        repository = get()
    )}

    factory<UpdateCategoryUseCase> { UpdateCategoryUseCase(
        repository = get()
    ) }

    factory<AllFavoritesUseCase> { AllFavoritesUseCase(
        repository = get()
    ) }

    factory<InsertFavoritesUseCase> {  InsertFavoritesUseCase(
        repository = get()
    )}

    factory<DeleteFavoritesUseCase> { DeleteFavoritesUseCase(
        repository = get()
    ) }
}