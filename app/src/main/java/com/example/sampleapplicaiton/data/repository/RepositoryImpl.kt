package com.example.sampleapplicaiton.data.repository

import com.example.sampleapplicaiton.domain.model.DisneyData
import com.example.sampleapplicaiton.data.remote.DisneyApi
import com.example.sampleapplicaiton.domain.repository.DisneyRepository
import javax.inject.Inject

class DisneyRepositoryImpl @Inject constructor(
    private val api: DisneyApi,
) : DisneyRepository {
    override suspend fun getDisneyDetails(): List<DisneyData> = api.getDisneyDetails().data
}