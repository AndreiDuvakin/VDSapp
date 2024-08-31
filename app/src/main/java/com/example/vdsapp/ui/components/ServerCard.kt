package com.example.vdsapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.vdsapp.network.models.responses.Server
import com.example.vdsapp.ui.HomeViewModel
import com.example.vdsapp.utils.LocationUtils
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServerCard(
    server: Server,
    homeViewModel: HomeViewModel
) {
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

    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()

    if (showServerBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showServerBottomSheet = false
            },
            sheetState = sheetState
        ) {
            ServerBottomSheet(server = server)
        }
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                coroutineScope.launch {
                    showServerBottomSheet = true
                }
            },
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
                    IconButton(onClick = { actionExpanded = true }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }

                    DropdownMenu(
                        expanded = actionExpanded,
                        onDismissRequest = { actionExpanded = false }
                    ) {
                        if (server.status == "started") {
                            DropdownMenuItem(
                                text = { Text("Перезагрузить") },
                                onClick = {
                                    actionExpanded = false
                                    homeViewModel.restartServer(server.ctid!!)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Остановить") },
                                onClick = {
                                    actionExpanded = false
                                    homeViewModel.stopServer(server.ctid!!)
                                }
                            )
                        } else if (server.status == "stopped") {
                            DropdownMenuItem(
                                text = { Text("Запустить") },
                                onClick = {
                                    actionExpanded = false
                                    homeViewModel.startServer(server.ctid!!)
                                }
                            )
                        }
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

            Text(text = "Локация: ${LocationUtils.getCityNameByLocationCode(server.location ?: "")}")

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Имя хоста: ${server.hostname ?: "Неизвестно"}")
            Text(text = "Происхождение: ${server.madeFrom ?: "Неизвестно"}")
        }
    }
}
