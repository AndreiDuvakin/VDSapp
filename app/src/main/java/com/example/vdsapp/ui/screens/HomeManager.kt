package com.example.vdsapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.vdsapp.ui.HomeUiStates

@Composable
fun HomeManager (
    homeUiState: HomeUiStates,
    navController: NavHostController,
    retryAction: () -> Unit,
) {
    when (homeUiState) {
        is HomeUiStates.Success -> {
            HomeScreen(servers = homeUiState.getServers, navController = navController)
        }
        is HomeUiStates.Loading -> {
            LoadingScreen(navController = navController)
        }
        is HomeUiStates.Error -> {
            ErrorScreen(retryAction = retryAction, navController = navController)
        }
    }
}