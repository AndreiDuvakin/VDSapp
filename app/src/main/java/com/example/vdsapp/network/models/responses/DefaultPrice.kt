package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class DefaultPrice(
    @SerializedName("backup") val backup: Int,
    @SerializedName("huge") val huge: PriceDetail,
    @SerializedName("large") val large: PriceDetail,
    @SerializedName("medium") val medium: PriceDetail,
    @SerializedName("monster") val monster: PriceDetail,
    @SerializedName("small") val small: PriceDetail
)
