package com.example.weddingplanner.di

import com.example.data.db.AppDatabase
import com.example.data.mappers.NoteEntityMapper
import com.example.data.repositories.TodoLocalDataSource
import com.example.data.repositories.TodoLocalDataSourceImpl
import com.example.data.repositories.TodoRepositoryImpl
import com.example.domain.repository.TodoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<TodoLocalDataSource> { TodoLocalDataSourceImpl(get(), get()) }
    single<TodoRepository> { TodoRepositoryImpl(get()) }
    single { AppDatabase.getDatabase(context = androidContext()).noteDao() }
    single { NoteEntityMapper() }
}