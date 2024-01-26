package com.mahammadjafarzade.domain.usecases

import com.mahammadjafarzade.common.flowstate.Resource
import com.mahammadjafarzade.data.repository.FlightRepository
import com.mahammadjafarzade.data.repository.FlightRepositoryInterface
import com.mahammadjafarzade.domain.mapper.SearchResponseToUIStateMapper
import com.mahammadjafarzade.entities.model.SearchResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchListUseCase @Inject constructor(
    private val repository: FlightRepositoryInterface,
    private val mapper: SearchResponseToUIStateMapper) {
    suspend fun getList() = flow {
        emit(Resource.Loading())
        repository.getFlights()?.data?.let {

            emit(Resource.Success(it))

        } ?: emit(Resource.Error("Empty message error"))
    }.catch {exception ->
        emit(Resource.Error(exception.localizedMessage))
    }
}