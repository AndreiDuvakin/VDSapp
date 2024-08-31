package com.example.vdsapp.network.models.requests

import com.google.gson.annotations.SerializedName

data class CreateTag (
    @SerializedName("name") var name: String,
    @SerializedName("scalets") var scalets: List<Int>? = null,
)