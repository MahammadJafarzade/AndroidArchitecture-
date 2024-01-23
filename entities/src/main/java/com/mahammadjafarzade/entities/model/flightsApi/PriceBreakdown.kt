package com.sirketismi.entities.model

data class PriceBreakdown(
    val base: Int,
    val currency: String,
    val discount: Int,
    val displayed_currency: String,
    val extra_fee: Int,
    val internal_assurance: Int,
    val penalty: Int,
    val reissue_service: Int,
    val service: Double,
    val tax: Int,
    val total: Double
)