package com.example.vdsapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vdsapp.data.TokenManager
import com.example.vdsapp.ui.screens.TokenInputScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VDSApp(navController: NavHostController, tokenManager: TokenManager) {
    val token = tokenManager.token

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("VDS App") })
        },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = if (token == null) "token_input" else "account",
                Modifier.padding(innerPadding)
            ) {
                composable("token_input") {
                    TokenInputScreen(
                        onTokenEntered = {
                            navController.navigate("home") {
                                popUpTo("token_input") { inclusive = true }
                            }
                        },
                        tokenManager = tokenManager
                    )
                }
                // composable("account") { AccountScreen(navController) }
                // composable("server") { ServerScreen(navController) }
            }
        }
    )
}
