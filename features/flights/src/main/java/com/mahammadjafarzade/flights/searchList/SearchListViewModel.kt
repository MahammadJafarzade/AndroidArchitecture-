package com.mahammadjafarzade.flights.searchList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahammadjafarzade.data.repository.FlightRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.mahammadjafarzade.entities.model.SearchResponse
import kotlinx.coroutines.launch

@HiltViewModel
class SearchListViewModel @Inject constructor(val repositoryInterface : FlightRepositoryInterface) : ViewModel() {
    val data = MutableLiveData<SearchResponse?>()
    fun getFlights() {
        viewModelScope.launch {
            repositoryInterface.getFlights()?.let {
                data.postValue(it)
            }
        }
    }
}