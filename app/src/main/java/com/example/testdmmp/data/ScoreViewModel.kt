package com.example.testdmmp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScoreViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Score>>
    private val repository: ScoreRepository

    init {
        val userDao = ScoreDatabase.getDatabase(application).scoreDao()
        repository = ScoreRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addScore(score: Score){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addScore(score)
        }
    }



}