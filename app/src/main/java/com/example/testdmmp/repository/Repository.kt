package com.example.testdmmp.repository

import com.example.testdmmp.api.RetrofitInstance
import com.example.testdmmp.models.Planet
import retrofit2.Response

class Repository {

    suspend fun getPlanet():Response<List<Planet>>{
       return  RetrofitInstance.api.getPlanet()
    }
}