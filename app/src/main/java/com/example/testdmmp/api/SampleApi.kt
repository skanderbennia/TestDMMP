package com.example.testdmmp.api

import com.example.testdmmp.models.Planet
import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {
    @GET("fichierjson.json")
    suspend fun getPlanet(): Response<List<Planet>>
}