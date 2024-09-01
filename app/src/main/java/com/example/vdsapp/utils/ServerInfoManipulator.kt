package com.example.vdsapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.vdsapp.R

object ServerInfoManipulator {
    @Composable
    fun getCityNameByLocationCode(locationCode: String): String {
        return when {
            locationCode.startsWith("spb") -> stringResource(R.string.location_spb)
            locationCode.startsWith("msk") -> stringResource(R.string.location_msk)
            else -> stringResource(R.string.location_nothing)
        }
    }

    @Composable
    fun getLogoByDistribution(distribution: String): Painter {
        return when {
            distribution.startsWith("ubuntu") -> painterResource(R.drawable.ubuntu)
            distribution.startsWith("fedora") -> painterResource(R.drawable.fedora)
            distribution.startsWith("debian") -> painterResource(R.drawable.debian)
            distribution.startsWith("centos") -> painterResource(R.drawable.cent_os)
            else -> painterResource(R.drawable.some_linux)
        }
    }
}