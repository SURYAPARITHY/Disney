package com.example.sampleapplicaiton.di

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
object AppModule {

    @Provides
    @Singleton
    fun provideDisneyApi(): DisneyApi =
        Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/")
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