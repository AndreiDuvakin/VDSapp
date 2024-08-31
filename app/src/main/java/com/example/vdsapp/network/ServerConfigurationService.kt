package com.example.vdsapp.network

import com.example.vdsapp.network.models.responses.ServerConfiguration
import retrofit2.http.GET
import retrofit2.http.Header

interface ServerConfigurationService {
    @GET("v1/rplans")
    suspend fun getAvailableServerConfigurations(
        @Header("X-Token")
        token: String
    ): List<ServerConfiguration>
}