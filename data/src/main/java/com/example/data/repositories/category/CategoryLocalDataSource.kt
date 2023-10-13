package com.example.data.repositories.category

import com.example.domain.entities.Categories
import com.example.domain.entities.Ready
import kotlinx.coroutines.flow.Flow

interface CategoryLocalDataSource {

    fun getAllCategory() : Flow<List<Categories>>

    suspend fun getInsert(categories: List<Categories>)

    suspend fun getUpdate(categories: Categories)
}