package com.example.vdsapp.data

import com.example.vdsapp.network.ServerConfigurationService
import com.example.vdsapp.network.models.responses.ServerConfiguration

interface ServerConfigurationsRepository {
    suspend fun getAvailableConfigurations(token: String): List<ServerConfiguration>
}

class NetworkServerConfigurationsRepository(
    private val serverConfigurationService: ServerConfigurationService
) : ServerConfigurationsRepository {
    override suspend fun getAvailableConfigurations(token: String): List<ServerConfiguration> {
        return serverConfigurationService.getAvailableServerConfigurations(token)
    }
}