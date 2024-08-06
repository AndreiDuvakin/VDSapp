package com.example.vdsapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.vdsapp.network.models.responses.Server

@Composable
fun ServerList(servers: List<Server>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(servers) { server ->
            ServerCard(server = server)
        }
    }
}