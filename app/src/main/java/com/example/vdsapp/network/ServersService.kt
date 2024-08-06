package com.example.vdsapp.network

import com.example.vdsapp.network.models.responses.Server
import retrofit2.http.GET
import retrofit2.http.Header

interface ServersService {
    @GET("v1/scalets")
    suspend fun getServers(@Header("X-Token") token: String): List<Server>
}