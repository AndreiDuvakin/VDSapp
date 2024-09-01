package com.example.vdsapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.vdsapp.network.models.responses.PriceDetail
import com.example.vdsapp.network.models.responses.ServerConfiguration
import com.example.vdsapp.utils.MemoryManipulator.formatMemoryValue
import com.example.vdsapp.utils.PriceConfigurationManipulator.convertKopecksToRubles
import com.example.vdsapp.utils.ToIntIfNecessary.toIntIfNecessary

@Composable
fun ServerConfigurationRow(
    serverConfiguration: ServerConfiguration,
    currentPrice: PriceDetail,
) {
    val memoryText = formatMemoryValue(serverConfiguration.memory)
    val diskSizeText = formatMemoryValue(serverConfiguration.disk)
    val priceText = "${toIntIfNecessary(
        convertKopecksToRubles(currentPrice.month)
    )} ₽"

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(memoryText)
        Text(diskSizeText)
        Text("${serverConfiguration.cpus} ЦП")
        Text(priceText)
    }
}