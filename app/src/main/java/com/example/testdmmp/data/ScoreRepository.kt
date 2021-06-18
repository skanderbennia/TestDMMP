package com.example.testdmmp.data

import androidx.lifecycle.LiveData

class ScoreRepository(private val scoreDao: DaoScore) {

    val readAllData: LiveData<List<Score>> = scoreDao.readAllData()
    suspend fun addScore(score: Score){
        scoreDao.addScore(score)
    }
}