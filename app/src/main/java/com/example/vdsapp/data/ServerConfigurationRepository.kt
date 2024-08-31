package com.example.vdsapp.data

import com.example.vdsapp.network.ServerConfigurationService
import com.example.vdsapp.network.models.responses.ServerConfiguration

interface ServerConfigurationRepository {
    suspend fun getAvailableConfigurations(token: String): List<ServerConfiguration>
}

class NetworkServerConfigurationRepository(
    private val serverConfigurationService: ServerConfigurationService
) : ServerConfigurationRepository {
    override suspend fun getAvailableConfigurations(token: String): List<ServerConfiguration> {
        return serverConfigurationService.getAvailableServerConfigurations(token)
    }
}