package com.example.vdsapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.vdsapp.VDSApplication
import com.example.vdsapp.data.AccountRepository
import com.example.vdsapp.data.TokenManager
import com.example.vdsapp.network.models.responses.Account
import kotlinx.coroutines.launch
import okio.IOException

sealed interface AccountUiState {
    data class Success(val accountInfoGet: Account) : AccountUiState
    object Error : AccountUiState
    object Loading : AccountUiState
}

class AccountViewModel(
    private val accountRepository: AccountRepository,
    private val tokenManager: TokenManager
) : ViewModel() {
    var accountUiState = mutableStateOf<AccountUiState>(AccountUiState.Loading)
        private set

    init {
        tokenManager.token?.let {
            getAccountInfo(it)
        }
    }

    fun getAccountInfo(token: String) {
        viewModelScope.launch {
            accountUiState.value = AccountUiState.Loading
            accountUiState.value = try {
                AccountUiState.Success(accountRepository.getAccountInfo(token))
            } catch (e: IOException) {
                AccountUiState.Error
            } catch (e: HttpException) {
                AccountUiState.Error
            } catch (e: retrofit2.HttpException) {
                AccountUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as VDSApplication)
                val accountRepository = application.container.accountRepository
                val tokenManager = application.tokenManager
                AccountViewModel(accountRepository = accountRepository, tokenManager = tokenManager)
            }
        }
    }
}
