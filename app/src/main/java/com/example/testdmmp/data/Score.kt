package com.example.testdmmp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_data")
data class Score (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val value:Int
)