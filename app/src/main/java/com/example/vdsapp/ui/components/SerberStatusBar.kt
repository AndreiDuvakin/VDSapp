package com.example.vdsapp.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.vdsapp.model.ServerStatus

@Composable
fun ServerStatusBar(status: String?) {
    val serverStatus = when (status) {
        "started" -> ServerStatus.STARTED
        "stopped" -> ServerStatus.STOPPED
        "billing" -> ServerStatus.BILLING
        else -> ServerStatus.UNKNOWN
    }

    Text(
        text = serverStatus.displayText,
        style = MaterialTheme.typography.bodyLarge,
        color = serverStatus.color
    )
}