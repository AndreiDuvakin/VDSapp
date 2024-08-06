package com.example.vdsapp.network

import com.example.vdsapp.network.models.responses.Server
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path

interface ServersService {
    @GET("v1/scalets")
    suspend fun getServers(@Header("X-Token") token: String): List<Server>

    @PATCH("v1/scalets/{ctid}/restart")
    suspend fun restartServer(
        @Path("ctid") ctid: Int,
        @Header("X-Token") token: String
    ): Server

    @PATCH("v1/scalets/{ctid}/stop")
    suspend fun stopServer(
        @Path("ctid") ctid: Int,
        @Header("X-Token") token: String
    ): Server

    @PATCH("v1/scalets/{ctid}/start")
    suspend fun startServer(
        @Path("ctid") ctid: Int,
        @Header("X-Token") token: String
    ): Server
}