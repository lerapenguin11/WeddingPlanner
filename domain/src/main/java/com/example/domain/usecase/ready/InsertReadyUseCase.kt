package com.example.domain.usecase.ready

import com.example.domain.entities.Ready
import com.example.domain.entities.Todo
import com.example.domain.repository.ReadyRepository

class InsertReadyUseCase(private val repository: ReadyRepository) {

    suspend operator fun invoke(ready : List<Ready>) = repository.getInsert(ready = ready)
}