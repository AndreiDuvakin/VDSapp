package com.example.vdsapp.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ServerTextItem(label: String, value: String?) {
    Text(
        text = "$label: ${value ?: "Неизвестно"}",
        style = MaterialTheme.typography.bodyMedium
    )
}
