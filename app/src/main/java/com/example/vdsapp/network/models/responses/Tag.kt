package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("scalets") var scalets: List<Int>? = null
)
