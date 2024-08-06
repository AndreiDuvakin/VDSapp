package com.example.vdsapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.vdsapp.network.models.responses.Server
import com.example.vdsapp.ui.HomeViewModel

@Composable
fun ServerList(
    servers: List<Server>,
    homeViewModel: HomeViewModel,
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(servers) { server ->
            ServerCard(
                server = server,
                homeViewModel = homeViewModel,
            )
        }
    }
}