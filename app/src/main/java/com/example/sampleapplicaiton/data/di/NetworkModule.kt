package com.example.sampleapplicaiton.data.di

import android.os.Build
import androidx.core.os.BuildCompat
import com.example.sampleapplicaiton.BuildConfig
import com.example.sampleapplicaiton.data.remote.DisneyApi
import com.example.sampleapplicaiton.data.repository.DisneyRepositoryImpl
import com.example.sampleapplicaiton.domain.repository.DisneyRepository
import com.example.sampleapplicaiton.domain.usecase.GetDisneyDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideDisneyApi(): DisneyApi =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DisneyApi::class.java)

    @Provides
    @Singleton
    fun provideDisneyRepository(api: DisneyApi): DisneyRepository = DisneyRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetDisneyDataUseCase(repository: DisneyRepository): GetDisneyDetailsUseCase =
        GetDisneyDetailsUseCase(repository)

}