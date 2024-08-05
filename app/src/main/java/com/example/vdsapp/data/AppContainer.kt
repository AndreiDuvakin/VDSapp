package com.example.vdsapp.data

import com.example.vdsapp.network.AccountService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val accountRepository: AccountRepository
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

    override val accountRepository: AccountRepository by lazy {
        NetworkAccountRepository(retrofitAccountInfo)
    }
}