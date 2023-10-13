package com.example.domain.repository

import com.example.domain.entities.Categories
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getAllCategory() : Flow<List<Categories>>

    suspend fun getInsertCategory(category: List<Categories>)

    suspend fun getUpdateCategory(category: Categories)
}