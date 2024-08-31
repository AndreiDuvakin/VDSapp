package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class Server(
    @SerializedName("status") var status: String? = null,
    @SerializedName("rplan") var rplan: String? = null,
    @SerializedName("locked") var locked: Boolean? = null,
    @SerializedName("keys") var keys: ArrayList<Keys> = arrayListOf(),
    @SerializedName("private_address") var privateAddress: PrivateAddress? = PrivateAddress(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("ctid") var ctid: Int? = null,
    @SerializedName("public_address") var publicAddress: PublicAddress? = PublicAddress(),
    @SerializedName("hostname") var hostname: String? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("made_from") var madeFrom: String? = null,
)