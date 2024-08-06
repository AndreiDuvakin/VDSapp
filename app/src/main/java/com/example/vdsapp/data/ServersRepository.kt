package com.example.vdsapp.data

import com.example.vdsapp.network.ServersService
import com.example.vdsapp.network.models.responses.Server

interface ServersRepository {
    suspend fun getServers(token: String) : List<Server>
}

class NetworkServersRepository(
    private val serversService: ServersService
) : ServersRepository {
    override suspend fun getServers(token: String): List<Server> {
        return serversService.getServers(token)
    }
}