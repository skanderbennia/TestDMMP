package com.example.testdmmp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao()
interface DaoScore {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addScore(score: Score)
    @Query("SELECT * FROM score_data ORDER BY value DESC ")
    fun readAllData():LiveData<List<Score>>
}