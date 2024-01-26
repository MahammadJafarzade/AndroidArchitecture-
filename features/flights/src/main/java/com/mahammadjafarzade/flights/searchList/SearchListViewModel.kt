package com.mahammadjafarzade.flights.searchList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.mahammadjafarzade.common.flowstate.Resource
import com.mahammadjafarzade.common.flowstate.State
import com.mahammadjafarzade.domain.mapper.SearchResponseToUIStateMapper
import com.mahammadjafarzade.domain.usecases.SearchListUseCase
import com.mahammadjafarzade.entities.uimodel.FlightSearchUIState
import kotlinx.coroutines.flow.MutableStateFlow
import com.mahammadjafarzade.entities.model.Data
import kotlinx.coroutines.flow.collectLatest



@HiltViewModel
class SearchListViewModel @Inject constructor(
    val searchUseCase : SearchListUseCase,
    private val mapper: SearchResponseToUIStateMapper) : ViewModel() {
    val state : MutableStateFlow<State?> = MutableStateFlow(null)
    val data = MutableLiveData<FlightSearchUIState?>()

    suspend fun getFlights() {
        searchUseCase.getList().collectLatest {
            when(it) {
                is Resource.Error -> state.emit(State.error(it.message))
                is Resource.Loading -> state.emit(State.loading())
                is Resource.Success -> {
                    state.emit(State.success())

                    it.data?.let {
                        val mappedData = mapper.map(it)
                        data.postValue(mappedData)
                    }
                }
            }
        }
    }
}