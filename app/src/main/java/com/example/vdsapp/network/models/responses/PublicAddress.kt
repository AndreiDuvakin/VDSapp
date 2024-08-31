package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class PublicAddress(
    @SerializedName("gateway") var gateway: String? = null,
    @SerializedName("netmask") var netmask: String? = null,
    @SerializedName("address") var address: String? = null,
)