package com.example.vdsapp.data

import com.example.vdsapp.network.AccountService
import com.example.vdsapp.network.ServerConfigurationService
import com.example.vdsapp.network.ServersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val accountRepository: AccountRepository
    val serversRepository: ServersRepository
    val serverConfigurationRepository: ServerConfigurationRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://api.vscale.io/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    private val retrofitAccountInfo: AccountService by lazy {
        retrofit.create(AccountService::class.java)
    }

    private val retrofitServers: ServersService by lazy {
        retrofit.create(ServersService::class.java)
    }

    private val retrofitServerConfigurations: ServerConfigurationService by lazy {
        retrofit.create(ServerConfigurationService::class.java)
    }

    override val accountRepository: AccountRepository by lazy {
        NetworkAccountRepository(retrofitAccountInfo)
    }

    override val serversRepository: ServersRepository by lazy {
        NetworkServersRepository(retrofitServers)
    }

    override val serverConfigurationRepository: ServerConfigurationRepository by lazy {
        NetworkServerConfigurationRepository(retrofitServerConfigurations)
    }
}