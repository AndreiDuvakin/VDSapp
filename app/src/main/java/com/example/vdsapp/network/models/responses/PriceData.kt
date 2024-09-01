package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class PriceData(
    @SerializedName("default") val defaultPricing: DefaultPrice,
    @SerializedName("period") val period: String
)
