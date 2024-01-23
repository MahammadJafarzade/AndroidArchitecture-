package com.sirketismi.entities.model

data class Segment(
    val arrival_datetime: ArrivalDatetime,
    val available_seats: Int,
    val `class`: String,
    val departure_datetime: DepartureDatetime,
    val destination: String,
    val destination_terminal: Any,
    val display_arrival_datetime: String,
    val display_departure_datetime: String,
    val duration: Duration,
    val flight_number: String,
    val is_train: Boolean,
    val is_virtual_interlining: Boolean,
    val marketing_airline: String,
    val operating_airline: String,
    val origin: String,
    val origin_terminal: Any,
    val segment_attributes: SegmentAttributes,
    val segment_delay: Any
)