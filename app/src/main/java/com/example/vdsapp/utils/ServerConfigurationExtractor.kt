package com.example.vdsapp.utils

import com.example.vdsapp.network.models.responses.Server
import com.example.vdsapp.network.models.responses.ServerConfiguration

object ServerConfigurationExtractor {
    fun extractServerConfiguration(
        server: Server,
        serverConfigurations: List<ServerConfiguration>,
    ): ServerConfiguration? {
        val serverConfigurationId = server.rplan

        return serverConfigurations.find { it.id == serverConfigurationId }
    }
}