package com.example.vdsapp

import android.app.Application
import com.example.vdsapp.data.AppContainer
import com.example.vdsapp.data.DefaultAppContainer
import com.example.vdsapp.data.TokenManager

class VDSApplication : Application() {
    val tokenManager by lazy { TokenManager(this) }

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}