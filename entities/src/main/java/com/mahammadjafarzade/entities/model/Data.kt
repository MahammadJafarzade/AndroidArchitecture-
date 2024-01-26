package com.mahammadjafarzade.entities.model

data class Data(
    val airlines: List<Airline>,
    val airports: List<Airport>,
    val baggages: List<Int>,
    val bus_search_data_tab: Any,
    val created_at: String,
    val currencies: Currencies,
    val filter_boundaries: FilterBoundaries,
    val flights: Flights,
    val has_vi_flight: Boolean,
    val info_message: Any,
    val price_history: PriceHistory,
    val search_parameters: SearchParameters,
    val search_url: String,
    val short_search_url: String,
    val stop_counts: List<Int>
){

    override fun toString(): String {
        return "Data(airlines=$airlines, airports=$airports, baggages=$baggages, bus_search_data_tab=$bus_search_data_tab, created_at=$created_at, currencies=$currencies, filter_boundaries=$filter_boundaries, flights=$flights, has_vi_flight=$has_vi_flight, info_message=$info_message, price_history=$price_history, search_parameters=$search_parameters, search_url=$search_url, short_search_url=$short_search_url, stop_counts=$stop_counts)"
    }
}