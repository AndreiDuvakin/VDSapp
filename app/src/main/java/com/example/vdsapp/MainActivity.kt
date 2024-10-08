package com.example.vdsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.vdsapp.ui.AccountViewModel
import com.example.vdsapp.ui.VDSApp
import com.example.vdsapp.ui.theme.VDSappTheme


class MainActivity : ComponentActivity() {
    private val tokenManager by lazy { (application as VDSApplication).tokenManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VDSappTheme {
                val navController = rememberNavController()
                VDSApp(
                    navController = navController,
                    tokenManager = tokenManager,
                )
            }
        }
    }
}
