package com.example.vdsapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.vdsapp.R
import com.example.vdsapp.network.models.responses.Server

@Composable
fun ServerCard(server: Server) {
    var showServerBottomSheet by remember {
        mutableStateOf(false)
    }

    var actionExpanded by remember {
        mutableStateOf(false)
    }

    val statusText = when (server.status) {
        "started" -> "Запущен"
        "stopped" -> "Остановлен"
        "billing" -> "Заблокирован"
        else -> "Неизвестен"
    }

    val statusColor = when (server.status) {
        "started" -> Color.Green
        "stopped" -> Color.Red
        "billing" -> Color.Yellow
        else -> Color.Gray
    }


    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = statusText,
                    style = MaterialTheme.typography.bodyLarge,
                    color = statusColor
                )
                Box {


                    DropdownMenu(
                        expanded = actionExpanded,
                        onDismissRequest = { actionExpanded = false }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(
                                        Icons.Default.Refresh,
                                        contentDescription = stringResource(id = R.string.reboot_server)
                                    )
                                    Text("Перезагрузить")
                                }
                            },
                            onClick = {

                                actionExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Row {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = stringResource(id = R.string.stop_server)
                                    )
                                    Text("Остановить")
                                }
                            },
                            onClick = {

                                actionExpanded = false
                            }
                        )
                    }

                    IconButton(onClick = {
                        actionExpanded = true
                    }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            }

            Text(
                text = server.name ?: "Без имени",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "IP: ${server.publicAddress?.address ?: "Неизвестен"}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "План: ${server.rplan ?: "Неизвестен"}")
            Text(text = "Локация: ${server.location ?: "Неизвестна"}")


            Spacer(modifier = Modifier.height(8.dp))


            Text(text = "Имя хоста: ${server.hostname ?: "Неизвестно"}")
            Text(text = "Происхождение: ${server.madeFrom ?: "Неизвестно"}")

        }
    }
}