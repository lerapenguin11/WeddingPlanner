package com.example.data.repositories.category

import com.example.data.db.CategoryDao
import com.example.data.mappers.CategoryEntityMapper
import com.example.domain.entities.Categories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CategoryLocalDataSourceImpl(
    private val categoryDao: CategoryDao,
    private val categoryEntityMapper: CategoryEntityMapper) : CategoryLocalDataSource {
    override fun getAllCategory(): Flow<List<Categories>> {
        val readyFlow = categoryDao.getAllCategory()

        return readyFlow.map { list ->
            list.map { element ->
                categoryEntityMapper.toCategory(element)
            }
        }
    }

    override suspend fun getInsert(categories: List<Categories>) {
        withContext(Dispatchers.IO){
            categoryDao.insert(categoryEntityMapper.toCategoryEntityList(category  = categories))
        }
    }

    override suspend fun getUpdate(categories: Categories) {
        withContext(Dispatchers.IO){
            categoryDao.update(categoryEntityMapper.toCategoryEntity(categories = categories))
        }
    }
}