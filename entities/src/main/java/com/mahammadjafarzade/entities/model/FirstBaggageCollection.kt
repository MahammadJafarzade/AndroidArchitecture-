package com.mahammadjafarzade.entities.model

data class FirstBaggageCollection(
    val allowance: Int,
    val part: Int,
    val paxType: String,
    val small: Boolean,
    val type: String,
    val unit: String
)