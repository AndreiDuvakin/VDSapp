package com.example.vdsapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.vdsapp.R

object LocationUtils {
    @Composable
    fun getCityNameByLocationCode(locationCode: String): String {
        return when {
            locationCode.startsWith("spb") -> stringResource(R.string.location_spb)
            locationCode.startsWith("msk") -> stringResource(R.string.location_msk)
            else -> stringResource(R.string.location_nothing)
        }
    }
}