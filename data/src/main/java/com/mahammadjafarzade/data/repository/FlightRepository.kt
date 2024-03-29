package com.mahammadjafarzade.data.repository

import com.mahammadjafarzade.entities.model.SearchResponse
import com.mahammadjafarzade.network.api.ApiService
import javax.inject.Inject


interface FlightRepositoryInterface{
    suspend fun getFlights() : SearchResponse?
}

class FlightRepository @Inject constructor(private val apiService: ApiService) :
    FlightRepositoryInterface {
    override suspend fun getFlights() : SearchResponse? {
        return apiService.getFlights()
    }
}