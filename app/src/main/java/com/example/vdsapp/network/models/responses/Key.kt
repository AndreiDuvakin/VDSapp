package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class Key (
    @SerializedName("name") var name: String? = null,
    @SerializedName("id") var id: Int? = null,
)