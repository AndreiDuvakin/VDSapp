package com.example.vdsapp.data

import com.example.vdsapp.network.ServersService
import com.example.vdsapp.network.models.responses.Server

interface ServersRepository {
    suspend fun getServers(token: String): List<Server>
    suspend fun restartServer(token: String, ctid: Int): Server
    suspend fun stopServer(token: String, ctid: Int): Server
    suspend fun startServer(token: String, ctid: Int): Server
}

class NetworkServersRepository(
    private val serversService: ServersService
) : ServersRepository {
    override suspend fun getServers(token: String): List<Server> {
        return serversService.getServers(token)
    }

    override suspend fun restartServer(token: String, ctid: Int): Server {
        return serversService.restartServer(ctid, token)
    }

    override suspend fun stopServer(token: String, ctid: Int): Server {
        return serversService.stopServer(ctid, token)
    }

    override suspend fun startServer(token: String, ctid: Int): Server {
        return serversService.startServer(ctid, token)
    }
}