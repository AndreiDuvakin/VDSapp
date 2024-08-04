package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class Backup (
    @SerializedName("id") var id: String? = null,
    @SerializedName("template") var template: String? = null,
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("scalet") var scalet: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("size") var size: Int? = null,
    @SerializedName("locked") var locked: Boolean? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("created") var created: String? = null
)