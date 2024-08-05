package com.example.vdsapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vdsapp.data.TokenManager

@Composable
fun TokenInputScreen(
    onTokenEntered: (String) -> Unit,
    tokenManager: TokenManager
) {
    var token by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Введите токен",
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = token,
            onValueChange = { token = it },
            label = { Text("Токен") },
            isError = errorMessage != null
        )
        errorMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (token.isNotBlank()) {
                tokenManager.token = token
                onTokenEntered(token)
            } else {
                errorMessage = "Токен не может быть пустым"
            }
        }) {
            Text("Сохранить")
        }
    }
}