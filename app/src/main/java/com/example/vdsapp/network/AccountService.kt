package com.example.vdsapp.network

import com.example.vdsapp.network.models.responses.Account
import retrofit2.http.GET
import retrofit2.http.Header

interface AccountService {
    @GET("v1/account")
    suspend fun accountInfoGet(@Header("X-Token") token: String): Account
}