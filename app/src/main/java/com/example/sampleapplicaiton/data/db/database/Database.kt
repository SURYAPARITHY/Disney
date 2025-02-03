package com.example.sampleapplicaiton.data.db.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.sampleapplicaiton.data.db.dao.CharacterDAO
import com.example.sampleapplicaiton.data.db.model.Characters
import com.example.sampleapplicaiton.domain.model.DisneyData


@Database(entities = [Characters::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun characterDao(): CharacterDAO
}