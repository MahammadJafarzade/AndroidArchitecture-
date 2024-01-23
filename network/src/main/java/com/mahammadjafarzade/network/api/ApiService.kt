package com.mahammadjafarzade.network.api


import com.mahammadjafarzade.entities.model.SearchResponse
import retrofit2.http.GET

interface ApiService {
    @GET("flights")
    suspend fun getFlights() : SearchResponse?

}