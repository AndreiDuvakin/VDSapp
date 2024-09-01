package com.example.vdsapp.utils

object ToIntIfNecessary {
    fun toIntIfNecessary(checkedDigit: Double): Number {
        return if (checkedDigit % 1 == 0.0) checkedDigit.toInt() else checkedDigit
    }
}