package com.example.sampleapplicaiton.domain.repository

import com.example.sampleapplicaiton.domain.model.DisneyData

interface DisneyRepository{
    suspend fun getDisneyDetails(): List<DisneyData>
}