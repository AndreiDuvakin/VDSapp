package com.example.vdsapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.vdsapp.network.models.responses.Account

@Composable
fun AccountScreen(
    account: Account,
) {
    account.info?.name?.let { Text(text = it) }
}