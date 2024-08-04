package com.example.vdsapp.data

import com.example.vdsapp.network.AccountService
import com.example.vdsapp.network.models.responses.Account


interface AccountRepository {
    suspend fun getAccountInfo(token: String): Account
}

class NetworkAccountRepository(
    private val accountService: AccountService
) : AccountRepository {
    override suspend fun getAccountInfo(token: String): Account {
        return accountService.accountInfoGet(token)
    }
}