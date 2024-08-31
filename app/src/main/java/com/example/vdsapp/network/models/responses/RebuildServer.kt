package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class RebuildServer(
    @SerializedName("made_from") var madeFrom: String? = null,
    @SerializedName("hostname") var hostname: String? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("created") var created: String? = null,
    @SerializedName("locked") var locked: Boolean? = null,
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("rplan") var rplan: String? = null,
    @SerializedName("keys") var keys: List<Key>? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("private_address") var privateAddress: PrivateAddress? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("deleted") var deleted: String? = null,
    @SerializedName("ctid") var ctid: Int? = null,
    @SerializedName("public_address") var publicAddress: PublicAddress? = null,
)
