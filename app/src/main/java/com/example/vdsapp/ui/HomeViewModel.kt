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
import com.example.vdsapp.data.ServersRepository
import com.example.vdsapp.data.TokenManager
import com.example.vdsapp.network.models.responses.Server
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface HomeUiStates {
    data class Success(val getServers: List<Server>) : HomeUiStates
    data object Error : HomeUiStates
    data object Loading : HomeUiStates
}


class HomeViewModel(
    private val serversRepository: ServersRepository,
    private val tokenManager: TokenManager,
) : ViewModel() {
    val homeUiState = mutableStateOf<HomeUiStates>(HomeUiStates.Loading)

    init {
        tokenManager.token?.let {
            getServers(it)
        }
    }

    fun getServers(token: String) {
        viewModelScope.launch {
            homeUiState.value = HomeUiStates.Loading
            homeUiState.value = try {
                HomeUiStates.Success(serversRepository.getServers(token))
            } catch (e: IOException) {
                HomeUiStates.Error
            } catch (e: HttpException) {
                HomeUiStates.Error
            } catch (e: retrofit2.HttpException) {
                HomeUiStates.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as VDSApplication)
                val serversRepository = application.container.serversRepository
                val tokenManager = application.tokenManager
                HomeViewModel(serversRepository = serversRepository, tokenManager = tokenManager)
            }
        }
    }
}