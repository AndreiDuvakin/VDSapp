package com.example.vdsapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.vdsapp.ui.AccountUiState

@Composable
fun AccountManager(
    accountUiState: AccountUiState,
    retryAction: () -> Unit,
    navController: NavHostController
) {
    when (accountUiState) {
        is AccountUiState.Success -> AccountScreen(
            account = accountUiState.accountInfoGet,
        )

        is AccountUiState.Loading -> LoadingScreen(
        )

        is AccountUiState.Error -> ErrorScreen(
            retryAction = retryAction,
        )
    }
}