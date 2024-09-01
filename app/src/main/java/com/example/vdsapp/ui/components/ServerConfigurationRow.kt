package com.example.vdsapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.vdsapp.network.models.responses.ServerConfiguration
import com.example.vdsapp.utils.MemoryConverter
import com.example.vdsapp.utils.ToIntIfNecessary

@Composable
fun ServerConfigurationRow(serverConfiguration: ServerConfiguration) {
    val memory = MemoryConverter.convertMbToGbIfNecessary(serverConfiguration.memory)
    val memoryString = ToIntIfNecessary.toIntIfNecessary(memory).toString()

    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            "$memoryString ГБ",
        )
    }
}