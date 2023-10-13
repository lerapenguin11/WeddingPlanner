package com.example.domain.usecase.category

import com.example.domain.repository.CategoryRepository

class AllCategoryUseCase(private val repository: CategoryRepository) {

    operator fun invoke() = repository.getAllCategory()
}