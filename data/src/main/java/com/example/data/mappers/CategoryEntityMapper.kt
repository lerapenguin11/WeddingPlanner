package com.example.data.mappers

import com.example.data.entities.CategoryEntity
import com.example.data.entities.ReadyEntity
import com.example.domain.entities.Categories
import com.example.domain.entities.Ready

class CategoryEntityMapper {

    fun toCategoryEntity(categories : Categories): CategoryEntity {
        return CategoryEntity(
            id = categories.id,
            isCompleted = categories.isCompleted,
            icon = categories.icon
        )
    }

    fun toCategory(categories : CategoryEntity): Categories {
        return Categories(
            id = categories.id,
            isCompleted = categories.isCompleted,
            icon = categories.icon
        )
    }

    fun toCategoryEntityList(category : List<Categories>): List<CategoryEntity> {
        val readyList = mutableListOf<CategoryEntity>()
        for (i in category){
            val id = i.id
            val isCompleted = i.isCompleted
            val icon = i.icon

            val readyEntity = CategoryEntity(id = id,isCompleted = isCompleted, icon = icon)

            readyList.add(readyEntity)
        }

        return readyList
    }
}