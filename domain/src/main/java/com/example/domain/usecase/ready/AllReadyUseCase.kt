package com.example.domain.usecase.ready

import com.example.domain.repository.ReadyRepository

class AllReadyUseCase(private val repository : ReadyRepository) {

    suspend operator fun invoke() = repository.getAllReady()
}