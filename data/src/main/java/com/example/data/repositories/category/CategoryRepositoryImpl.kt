package com.example.data.repositories.category

import com.example.domain.entities.Categories
import com.example.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(
    private val localDataSource: CategoryLocalDataSource)
    : CategoryRepository {
    override fun getAllCategory(): Flow<List<Categories>> {
        return localDataSource.getAllCategory()
    }

    override suspend fun getInsertCategory(category: List<Categories>) {
        localDataSource.getInsert(category)
    }

    override suspend fun getUpdateCategory(category: Categories) {
        localDataSource.getUpdate(category)
    }
}