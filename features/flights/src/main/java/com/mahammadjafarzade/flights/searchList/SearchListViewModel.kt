package com.mahammadjafarzade.flights.searchList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahammadjafarzade.data.repository.FlightRepositoryInterface
import com.sirketismi.entities.model.SearchResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class SearchListViewModel @Inject constructor(private val repositoryInterface : FlightRepositoryInterface) : ViewModel() {
    val data = MutableLiveData<SearchResponse?>()
    fun getFlights() {
        viewModelScope.launch {
            repositoryInterface.getFlights()?.let {
                data.postValue(it)
            }
        }
    }
}