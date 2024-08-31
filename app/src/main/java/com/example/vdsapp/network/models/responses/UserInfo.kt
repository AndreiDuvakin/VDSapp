package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class UserInfo (
    @SerializedName("actdate") var actdate: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("face_id") var faceId: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("locale") var locale: String? = null,
    @SerializedName("middlename") var middlename: String? = null,
    @SerializedName("mobile") var mobile: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("surname") var surname: String? = null,
)