package com.mahammadjafarzade.flights.searchList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.mahammadjafarzade.domain.usecases.SearchListUseCase
import com.mahammadjafarzade.entities.model.SearchResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class SearchListViewModel @Inject constructor(val searchUseCase: SearchListUseCase) : ViewModel() {
    val data = MutableLiveData<SearchResponse?>()
    suspend fun getFlights() {
        searchUseCase.getList().collect(){

        }
    }
}