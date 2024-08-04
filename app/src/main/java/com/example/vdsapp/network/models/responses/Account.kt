package com.example.vdsapp.network.models.responses

import com.google.gson.annotations.SerializedName

data class Account (
    @SerializedName("info") var info: UserInfo? = null
)