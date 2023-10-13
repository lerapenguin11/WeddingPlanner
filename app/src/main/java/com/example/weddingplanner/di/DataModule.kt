package com.example.weddingplanner.di

import com.example.data.db.AppDatabase
import com.example.data.mappers.NoteEntityMapper
import com.example.data.mappers.ReadyEntityMapper
import com.example.data.repositories.ready.ReadyLocalDataSource
import com.example.data.repositories.ready.ReadyLocalDataSourceImpl
import com.example.data.repositories.ready.ReadyRepositoryImpl
import com.example.data.repositories.todo.TodoLocalDataSource
import com.example.data.repositories.todo.TodoLocalDataSourceImpl
import com.example.data.repositories.todo.TodoRepositoryImpl
import com.example.domain.repository.ReadyRepository
import com.example.domain.repository.TodoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<TodoLocalDataSource> { TodoLocalDataSourceImpl(get(), get()) }
    single<TodoRepository> { TodoRepositoryImpl(get()) }
    single { AppDatabase.getDatabase(context = androidContext()).noteDao() }
    single { NoteEntityMapper() }

    single<ReadyLocalDataSource> { ReadyLocalDataSourceImpl(get(), get()) }
    single<ReadyRepository> { ReadyRepositoryImpl(get()) }
    single { AppDatabase.getDatabase(context = androidContext()).readyDao() }
    single { ReadyEntityMapper() }
}