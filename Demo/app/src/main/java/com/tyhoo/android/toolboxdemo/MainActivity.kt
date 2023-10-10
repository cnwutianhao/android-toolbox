package com.tyhoo.android.toolboxdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tyhoo.android.toolboxdemo.ui.AppView
import com.tyhoo.android.toolboxdemo.ui.HomeView
import com.tyhoo.android.toolboxdemo.ui.IsAppInstalledView
import com.tyhoo.android.toolboxdemo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "HomeView") {
                        composable("HomeView") {
                            HomeView(navController)
                        }
                        composable("AppView") {
                            AppView(navController)
                        }
                        composable("IsAppInstalledView") {
                            IsAppInstalledView()
                        }
                    }
                }
            }
        }
    }
}