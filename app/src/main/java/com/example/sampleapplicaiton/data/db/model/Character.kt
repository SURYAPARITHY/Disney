package com.example.sampleapplicaiton.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Characters(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name:String,
    val imageUrl: String
)
