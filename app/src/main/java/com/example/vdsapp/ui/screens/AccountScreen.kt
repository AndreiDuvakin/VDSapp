package com.example.vdsapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.vdsapp.network.models.responses.Account

@Composable
fun AccountScreen(
    account: Account,
    navController: NavHostController
) {
    account.info?.name?.let { Text(text = it) }
}