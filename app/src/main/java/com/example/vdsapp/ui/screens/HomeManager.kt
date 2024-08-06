package com.example.vdsapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.vdsapp.ui.HomeUiStates
import com.example.vdsapp.ui.HomeViewModel

@Composable
fun HomeManager (
    homeUiState: HomeUiStates,
    navController: NavHostController,
    retryAction: () -> Unit,
    homeViewModel: HomeViewModel,
) {
    when (homeUiState) {
        is HomeUiStates.Success -> {
            HomeScreen(
                servers = homeUiState.getServers,
                navController = navController,
                homeViewModel = homeViewModel,
            )
        }
        is HomeUiStates.Loading -> {
            LoadingScreen(navController = navController)
        }
        is HomeUiStates.Error -> {
            ErrorScreen(retryAction = retryAction, navController = navController)
        }
    }
}