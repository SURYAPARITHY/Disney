package com.example.sampleapplicaiton.data.di

import android.content.Context
import androidx.compose.animation.core.rememberTransition
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sampleapplicaiton.data.db.database.AppDatabase
import com.example.sampleapplicaiton.data.db.dao.CharacterDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "character_database"
        ).build()
    }

    @Provides
    fun provideCharacterDao(database: AppDatabase): CharacterDAO {
        return database.characterDao()
    }
}