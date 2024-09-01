package com.example.vdsapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.vdsapp.network.models.responses.PriceDetail
import com.example.vdsapp.network.models.responses.ServerConfiguration
import com.example.vdsapp.utils.MemoryConverter
import com.example.vdsapp.utils.PriceConfigurationManipulator
import com.example.vdsapp.utils.ToIntIfNecessary

@Composable
fun ServerConfigurationRow(
    serverConfiguration: ServerConfiguration,
    currentPrice: PriceDetail,
) {
    val (memory, unitOfMeasurementMemory) = MemoryConverter.convertMbToGbIfNecessary(
        serverConfiguration.memory,
    )
    val memoryAfterRounding = ToIntIfNecessary.toIntIfNecessary(memory)

    val (diskSize, unitOfMeasurementDiskSize) = MemoryConverter.convertMbToGbIfNecessary(
        serverConfiguration.disk,
    )
    val diskSizeAfterRounding = ToIntIfNecessary.toIntIfNecessary(diskSize)

    val priceWithRubles = PriceConfigurationManipulator.convertKopecksToRubles(currentPrice.month)
    val priceAfterRounded = ToIntIfNecessary.toIntIfNecessary(priceWithRubles)

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            "$memoryAfterRounding $unitOfMeasurementMemory",
        )
        Text(
            "$diskSizeAfterRounding $unitOfMeasurementDiskSize"
        )
        Text(
            "${serverConfiguration.cpus} ЦП"
        )
        Text(
            "$priceAfterRounded ₽"
        )
    }
}