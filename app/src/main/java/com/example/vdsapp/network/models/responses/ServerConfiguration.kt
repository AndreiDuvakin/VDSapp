package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class ServerConfiguration(
    @SerializedName("cpus") var cpus: Int? = null,
    @SerializedName("memory") var memory: Int? = null,
    @SerializedName("addresses") var addresses: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("disk") var disk: Int? = null,
    @SerializedName("locations") var locations: List<String>? = null,
)
