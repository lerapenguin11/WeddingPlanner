package com.example.domain.usecase.category

import com.example.domain.entities.Categories
import com.example.domain.entities.Ready
import com.example.domain.repository.CategoryRepository

class UpdateCategoryUseCase(private val repository: CategoryRepository) {

    suspend operator fun invoke(categories: Categories) = repository.getUpdateCategory(category = categories)
}