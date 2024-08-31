package com.example.vdsapp.model

import androidx.compose.ui.graphics.Color

enum class ServerStatus(val displayText: String, val color: Color) {
    STARTED("Запущен", Color.Green),
    STOPPED("Остановлен", Color.Red),
    BILLING("Заблокирован", Color.Yellow),
    UNKNOWN("Неизвестен", Color.Gray)
}