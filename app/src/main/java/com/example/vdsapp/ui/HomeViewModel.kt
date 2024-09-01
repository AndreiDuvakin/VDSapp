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
import com.example.vdsapp.data.ServerConfigurationRepository
import com.example.vdsapp.data.ServersRepository
import com.example.vdsapp.data.TokenManager
import com.example.vdsapp.network.models.responses.Server
import com.example.vdsapp.network.models.responses.ServerConfiguration
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface HomeUiStates {
    data class Success(
        val getServers: List<Server>,
        val getConfigurations: List<ServerConfiguration>
    ) : HomeUiStates

    data object Error : HomeUiStates
    data object Loading : HomeUiStates
}


class HomeViewModel(
    private val serversRepository: ServersRepository,
    private val tokenManager: TokenManager,
    private val serverConfigurationRepository: ServerConfigurationRepository,
) : ViewModel() {
    val homeUiState = mutableStateOf<HomeUiStates>(HomeUiStates.Loading)

    init {
        tokenManager.token?.let {
            loadData(it)
        }
    }

    fun loadData(token: String) {
        viewModelScope.launch {
            homeUiState.value = HomeUiStates.Loading
            homeUiState.value = try {
                val servers = serversRepository.getServers(token)
                val configurations = serverConfigurationRepository.getAvailableConfigurations(token)
                HomeUiStates.Success(servers, configurations)
            } catch (e: IOException) {
                HomeUiStates.Error
            } catch (e: HttpException) {
                HomeUiStates.Error
            } catch (e: retrofit2.HttpException) {
                HomeUiStates.Error
            }
        }
    }

    fun restartServer(ctid: Int) {
        tokenManager.token?.let { token ->
            viewModelScope.launch {
                try {
                    serversRepository.restartServer(token, ctid)
                    loadData(token)
                } catch (e: IOException) {
                    HomeUiStates.Error
                } catch (e: HttpException) {
                    HomeUiStates.Error
                } catch (e: retrofit2.HttpException) {
                    HomeUiStates.Error
                }
            }
        }
    }

    fun stopServer(ctid: Int) {
        tokenManager.token?.let { token ->
            viewModelScope.launch {
                try {
                    serversRepository.stopServer(token, ctid)
                    loadData(token)
                } catch (e: IOException) {
                    HomeUiStates.Error
                } catch (e: HttpException) {
                    HomeUiStates.Error
                } catch (e: retrofit2.HttpException) {
                    HomeUiStates.Error
                }
            }
        }
    }

    fun startServer(ctid: Int) {
        tokenManager.token?.let { token ->
            viewModelScope.launch {
                try {
                    serversRepository.startServer(token, ctid)
                    loadData(token)
                } catch (e: IOException) {
                    HomeUiStates.Error
                } catch (e: HttpException) {
                    HomeUiStates.Error
                } catch (e: retrofit2.HttpException) {
                    HomeUiStates.Error
                }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as VDSApplication)

                val serversRepository = application.container.serversRepository
                val serverConfigurationRepository =
                    application.container.serverConfigurationRepository

                val tokenManager = application.tokenManager

                HomeViewModel(
                    serversRepository = serversRepository,
                    tokenManager = tokenManager,
                    serverConfigurationRepository = serverConfigurationRepository,
                )
            }
        }
    }
}