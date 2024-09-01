package com.example.vdsapp.utils

import com.example.vdsapp.network.models.responses.PriceData
import com.example.vdsapp.network.models.responses.PriceDetail
import com.example.vdsapp.network.models.responses.Server

object PriceConfigurationManipulator {
    fun extractPriceConfiguration(
        server: Server,
        priceData: PriceData,
    ): PriceDetail? {
        val serverConfigurationId = server.rplan

        return when (serverConfigurationId) {
            "huge" -> priceData.defaultPricing.huge
            "large" -> priceData.defaultPricing.large
            "medium" -> priceData.defaultPricing.medium
            "monster" -> priceData.defaultPricing.monster
            "small" -> priceData.defaultPricing.small
            else -> null
        }
    }

    fun convertKopecksToRubles(kopecks: Int): Double = kopecks / 100.0
}