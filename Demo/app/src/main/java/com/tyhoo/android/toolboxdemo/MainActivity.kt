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
import com.tyhoo.android.toolboxdemo.ui.ExitAppView
import com.tyhoo.android.toolboxdemo.ui.GetApkInfoView
import com.tyhoo.android.toolboxdemo.ui.GetAppIconView
import com.tyhoo.android.toolboxdemo.ui.GetAppInfoView
import com.tyhoo.android.toolboxdemo.ui.GetAppMinSdkVersionView
import com.tyhoo.android.toolboxdemo.ui.GetAppNameView
import com.tyhoo.android.toolboxdemo.ui.GetAppPackageNameView
import com.tyhoo.android.toolboxdemo.ui.GetAppPathView
import com.tyhoo.android.toolboxdemo.ui.GetAppSignaturesMD5View
import com.tyhoo.android.toolboxdemo.ui.GetAppSignaturesSHA1View
import com.tyhoo.android.toolboxdemo.ui.GetAppSignaturesSHA256View
import com.tyhoo.android.toolboxdemo.ui.GetAppSignaturesView
import com.tyhoo.android.toolboxdemo.ui.GetAppTargetSdkVersionView
import com.tyhoo.android.toolboxdemo.ui.GetAppVersionCodeView
import com.tyhoo.android.toolboxdemo.ui.GetAppVersionNameView
import com.tyhoo.android.toolboxdemo.ui.GetAppsInfoView
import com.tyhoo.android.toolboxdemo.ui.HomeView
import com.tyhoo.android.toolboxdemo.ui.InstallAppView
import com.tyhoo.android.toolboxdemo.ui.IsAppDebugView
import com.tyhoo.android.toolboxdemo.ui.IsAppForegroundView
import com.tyhoo.android.toolboxdemo.ui.IsAppInstalledView
import com.tyhoo.android.toolboxdemo.ui.IsAppRootView
import com.tyhoo.android.toolboxdemo.ui.IsAppRunningView
import com.tyhoo.android.toolboxdemo.ui.IsAppSystemVew
import com.tyhoo.android.toolboxdemo.ui.IsFirstTimeInstalledView
import com.tyhoo.android.toolboxdemo.ui.LaunchAppDetailsSettingsView
import com.tyhoo.android.toolboxdemo.ui.LaunchAppView
import com.tyhoo.android.toolboxdemo.ui.RegisterAppStatusChangedListenerView
import com.tyhoo.android.toolboxdemo.ui.RelaunchAppView
import com.tyhoo.android.toolboxdemo.ui.UninstallAppView
import com.tyhoo.android.toolboxdemo.ui.UnregisterAppStatusChangedListenerView
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
                        composable("HomeView") { HomeView(navController) }

                        // App 相关
                        composable("AppView") { AppView(navController) }
                        composable("RegisterAppStatusChangedListenerView") { RegisterAppStatusChangedListenerView() }
                        composable("UnregisterAppStatusChangedListenerView") { UnregisterAppStatusChangedListenerView() }
                        composable("InstallAppView") { InstallAppView() }
                        composable("UninstallAppView") { UninstallAppView() }
                        composable("IsAppInstalledView") { IsAppInstalledView() }
                        composable("IsAppRootView") { IsAppRootView() }
                        composable("IsAppDebugView") { IsAppDebugView() }
                        composable("IsAppSystemVew") { IsAppSystemVew() }
                        composable("IsAppForegroundView") { IsAppForegroundView() }
                        composable("IsAppRunningView") { IsAppRunningView() }
                        composable("LaunchAppView") { LaunchAppView() }
                        composable("RelaunchAppView") { RelaunchAppView() }
                        composable("LaunchAppDetailsSettingsView") { LaunchAppDetailsSettingsView() }
                        composable("ExitAppView") { ExitAppView() }
                        composable("GetAppIconView") { GetAppIconView() }
                        composable("GetAppPackageNameView") { GetAppPackageNameView() }
                        composable("GetAppNameView") { GetAppNameView() }
                        composable("GetAppPathView") { GetAppPathView() }
                        composable("GetAppVersionNameView") { GetAppVersionNameView() }
                        composable("GetAppVersionCodeView") { GetAppVersionCodeView() }
                        composable("GetAppMinSdkVersionView") { GetAppMinSdkVersionView() }
                        composable("GetAppTargetSdkVersionView") { GetAppTargetSdkVersionView() }
                        composable("GetAppSignaturesView") { GetAppSignaturesView() }
                        composable("GetAppSignaturesSHA1View") { GetAppSignaturesSHA1View() }
                        composable("GetAppSignaturesSHA256View") { GetAppSignaturesSHA256View() }
                        composable("GetAppSignaturesMD5View") { GetAppSignaturesMD5View() }
                        composable("GetAppInfoView") { GetAppInfoView() }
                        composable("GetAppsInfoView") { GetAppsInfoView() }
                        composable("GetApkInfoView") { GetApkInfoView() }
                        composable("IsFirstTimeInstalledView") { IsFirstTimeInstalledView() }
                    }
                }
            }
        }
    }
}