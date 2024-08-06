package com.example.vdsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vdsapp.network.models.responses.Server
import com.example.vdsapp.ui.HomeViewModel
import com.example.vdsapp.ui.components.ServerList

@Composable
fun HomeScreen(
    servers: List<Server>,
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    Column {
        ServerList(
            servers = servers,
            homeViewModel = homeViewModel,
        )
    }
}