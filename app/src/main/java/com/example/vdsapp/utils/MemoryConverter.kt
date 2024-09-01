package com.example.vdsapp.utils

import java.io.Serializable

object MemoryConverter {
    fun convertMbToGbIfNecessary(mb: Int?): Pair<Double, String> {
        if (mb == null) return Pair(-1.0, "N/A")

        val memory = if (mb >= 1024) mb / 1024.0 else mb / 1.0
        val unitOfMeasurement = if (mb >= 1024) "ГБ" else "МБ"

        return Pair(memory, unitOfMeasurement)
    }
}