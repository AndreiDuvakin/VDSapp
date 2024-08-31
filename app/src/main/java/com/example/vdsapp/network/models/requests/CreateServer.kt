package com.example.vdsapp.network.models.requests

import com.google.gson.annotations.SerializedName

data class CreateServer(
    @SerializedName("make_from") var makeFrom: String,
    @SerializedName("rplan") var rplan: String,
    @SerializedName("do_start") var doStart: Boolean,
    @SerializedName("name") var name: String,
    @SerializedName("keys") var keys: List<Int>,
    @SerializedName("location") var location: String,
)