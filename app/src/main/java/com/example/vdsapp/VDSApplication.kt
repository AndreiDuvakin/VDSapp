package com.example.vdsapp

import android.app.Application
import com.example.vdsapp.data.AppContainer
import com.example.vdsapp.data.DefaultAppContainer

class VDSApplication : Application() {
    private lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}