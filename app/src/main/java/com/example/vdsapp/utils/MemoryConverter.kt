package com.example.vdsapp.utils

object MemoryConverter {
    fun convertMbToGbIfNecessary(mb: Int?): Double {
        if (mb == null) return -1.0
        return if (mb >= 1024) mb / 1024.0 else mb / 1.0
    }
}