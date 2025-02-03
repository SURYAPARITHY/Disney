package com.example.sampleapplicaiton.data.remote

import com.example.sampleapplicaiton.domain.model.Disney
import retrofit2.http.GET

interface DisneyApi {
    @GET("character")
    suspend fun getDisneyDetails(): Disney
}