package com.example.vdsapp.data

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    companion object {
        private const val TOKEN_KEY = "TOKEN_KEY"
    }

    var token: String?
        get() = sharedPreferences.getString(TOKEN_KEY, null)
        set(value) = sharedPreferences.edit().putString(TOKEN_KEY, value).apply()
}