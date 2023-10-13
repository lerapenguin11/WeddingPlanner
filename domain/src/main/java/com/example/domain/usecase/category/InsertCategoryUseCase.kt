package com.example.domain.usecase.category

import com.example.domain.entities.Categories
import com.example.domain.repository.CategoryRepository

class InsertCategoryUseCase(private val repository: CategoryRepository) {

    suspend operator fun invoke(category : List<Categories>) = repository.getInsertCategory(category = category)
}