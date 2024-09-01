package com.example.vdsapp.network

import com.example.vdsapp.network.models.responses.PriceData
import retrofit2.http.GET
import retrofit2.http.Header

interface PricesService {
    @GET("v1/billing/prices")
    suspend fun getPrices(@Header("X-Token") token: String): PriceData
}