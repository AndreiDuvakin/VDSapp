package com.example.vdsapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.vdsapp.network.models.responses.Server

@Composable
fun ServerBottomSheet(
    server: Server,
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = server.name ?: "Имя сервера не найдено",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}