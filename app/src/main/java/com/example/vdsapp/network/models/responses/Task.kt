package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class Task (
    @SerializedName("location") var location: String? = null,
    @SerializedName("d_insert") var dInsert: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("done") var done: Boolean? = null,
    @SerializedName("scalet") var scalet: Int? = null,
    @SerializedName("error") var error: Boolean? = null,
    @SerializedName("d_start") var dStart: String? = null,
    @SerializedName("method") var method: String? = null,
    @SerializedName("d_end") var dEnd: String? = null,
)