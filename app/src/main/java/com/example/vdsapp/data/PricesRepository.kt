package com.example.vdsapp.data

import com.example.vdsapp.network.PricesService
import com.example.vdsapp.network.models.responses.PriceData

interface PricesRepository {
    suspend fun getPrices(token: String): PriceData
}

class NetworkPricesRepository(
    private val pricingService: PricesService
) : PricesRepository {
    override suspend fun getPrices(token: String): PriceData {
        return pricingService.getPrices(token)
    }
}