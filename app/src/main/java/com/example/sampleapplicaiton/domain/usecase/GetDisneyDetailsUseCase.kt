package com.example.sampleapplicaiton.domain.usecase

import com.example.sampleapplicaiton.domain.model.DisneyData
import com.example.sampleapplicaiton.domain.repository.DisneyRepository
import javax.inject.Inject

class GetDisneyDetailsUseCase @Inject constructor(private val repository: DisneyRepository) {
    suspend operator fun invoke(): List<DisneyData> = repository.getDisneyDetails()
}