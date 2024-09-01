package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class PriceDetail(
    @SerializedName("hour") val hour: Int,
    @SerializedName("month") val month: Int
)
