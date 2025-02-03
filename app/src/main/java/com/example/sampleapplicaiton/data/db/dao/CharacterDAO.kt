package com.example.sampleapplicaiton.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sampleapplicaiton.data.db.model.Characters
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {
    @Query("Select * from Characters")
    fun getAllCharacter(): List<Characters>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(character: List<Characters>)

    @Query("Delete from Characters")
    suspend fun deleteAllCharacter()
}