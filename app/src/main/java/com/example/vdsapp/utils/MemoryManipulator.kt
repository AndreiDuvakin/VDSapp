package com.example.vdsapp.utils

object MemoryManipulator {
    private fun convertMbToGbIfNecessary(mb: Int?): Pair<Double, String> {
        if (mb == null) return Pair(-1.0, "N/A")

        val memory = if (mb >= 1024) mb / 1024.0 else mb / 1.0
        val unitOfMeasurement = if (mb >= 1024) "ГБ" else "МБ"

        return Pair(memory, unitOfMeasurement)
    }

    fun formatMemoryValue(value: Int?): String {
        val (convertedValue, unit) = this.convertMbToGbIfNecessary(value)
        val roundedValue = ToIntIfNecessary.toIntIfNecessary(convertedValue)
        return "$roundedValue $unit"
    }
}