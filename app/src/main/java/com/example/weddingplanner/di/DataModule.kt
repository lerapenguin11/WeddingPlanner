package com.example.weddingplanner.di

import com.example.data.db.AppDatabase
import com.example.data.mappers.CategoryEntityMapper
import com.example.data.mappers.FavoriteEntityMapper
import com.example.data.mappers.NoteEntityMapper
import com.example.data.mappers.ReadyEntityMapper
import com.example.data.repositories.category.CategoryLocalDataSource
import com.example.data.repositories.category.CategoryLocalDataSourceImpl
import com.example.data.repositories.category.CategoryRepositoryImpl
import com.example.data.repositories.favorite.FavoriteLocalDataSource
import com.example.data.repositories.favorite.FavoriteLocalDataSourceImpl
import com.example.data.repositories.favorite.FavoriteRepositoryImpl
import com.example.data.repositories.ready.ReadyLocalDataSource
import com.example.data.repositories.ready.ReadyLocalDataSourceImpl
import com.example.data.repositories.ready.ReadyRepositoryImpl
import com.example.data.repositories.todo.TodoLocalDataSource
import com.example.data.repositories.todo.TodoLocalDataSourceImpl
import com.example.data.repositories.todo.TodoRepositoryImpl
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.FavoriteRepository
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

    single<CategoryLocalDataSource> { CategoryLocalDataSourceImpl(get(), get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single { AppDatabase.getDatabase(context = androidContext()).categoryDao() }
    single { CategoryEntityMapper() }

    single<FavoriteLocalDataSource> { FavoriteLocalDataSourceImpl(get(), get()) }
    single<FavoriteRepository> { FavoriteRepositoryImpl(get()) }
    single { AppDatabase.getDatabase(context = androidContext()).favDao() }
    single { FavoriteEntityMapper() }
}