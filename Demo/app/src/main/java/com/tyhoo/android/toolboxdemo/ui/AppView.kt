package com.tyhoo.android.toolboxdemo.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tyhoo.android.toolboxdemo.GlobalUtils

@Composable
fun AppView(navController: NavHostController) {
    val context = LocalContext.current
    val items = listOf(
        "注册 App 前后台切换监听器",
        "注销 App 前后台切换监听器",
        "安装 App",
        "卸载 App",
        "判断 App 是否安装",
        "判断 App 是否有 root 权限",
        "判断 App 是否是 Debug 版本",
        "判断 App 是否是系统应用",
        "判断 App 是否处于前台",
        "判断 App 是否运行",
        "打开 App",
        "重启 App",
        "打开 App 具体设置",
        "关闭应用",
        "获取 App 图标",
        "获取 App 包名",
        "获取 App 名称",
        "获取 App 路径",
        "获取 App 版本号",
        "获取 App 版本码",
        "获取 App 支持最低系统版本号",
        "获取 App 目标系统版本号",
        "获取 App 签名",
        "获取应用签名的的 SHA1 值",
        "获取应用签名的的 SHA256 值",
        "获取应用签名的的 MD5 值",
        "获取 App 信息",
        "获取所有已安装 App 信息",
        "获取 Apk 信息",
        "判断应用是否首次安装"
    )
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(items) { item ->
            Text(text = item, style = TextStyle(fontSize = 20.sp), modifier = Modifier.clickable {
                when (item) {
                    "注册 App 前后台切换监听器" -> navController.navigate("RegisterAppStatusChangedListenerView")
                    "注销 App 前后台切换监听器" -> navController.navigate("UnregisterAppStatusChangedListenerView")
                    "安装 App" -> navController.navigate("InstallAppView")
                    "卸载 App" -> navController.navigate("UninstallAppView")
                    "判断 App 是否安装" -> navController.navigate("IsAppInstalledView")

                    "判断 App 是否有 root 权限" -> GlobalUtils.showToast(
                        context,
                        "${item}功能开发中"
                    )

                    "判断 App 是否是 Debug 版本" -> navController.navigate("IsAppDebugView")
                    "判断 App 是否是系统应用" -> navController.navigate("IsAppSystemVew")
                    "判断 App 是否处于前台" -> navController.navigate("IsAppForegroundView")

                    "判断 App 是否运行" -> GlobalUtils.showToast(
                        context,
                        "${item}功能开发中"
                    )

                    "打开 App" -> navController.navigate("LaunchAppView")
                    "重启 App" -> navController.navigate("RelaunchAppView")
                    "打开 App 详情设置页面" -> navController.navigate("LaunchAppDetailsSettingsView")

                    "关闭应用" -> GlobalUtils.showToast(
                        context,
                        "${item}功能开发中"
                    )

                    "获取 App 图标" -> navController.navigate("GetAppIconView")
                    "获取 App 包名" -> navController.navigate("GetAppPackageNameView")
                    "获取 App 名称" -> navController.navigate("GetAppNameView")
                    "获取 App 路径" -> navController.navigate("GetAppPathView")
                    "获取 App 版本号" -> navController.navigate("GetAppVersionNameView")
                    "获取 App 版本码" -> navController.navigate("GetAppVersionCodeView")
                    "获取 App 支持最低系统版本号" -> navController.navigate("GetAppMinSdkVersionView")
                    "获取 App 目标系统版本号" -> navController.navigate("GetAppTargetSdkVersionView")

                    "获取 App 签名" -> GlobalUtils.showToast(
                        context,
                        "${item}功能开发中"
                    )

                    "获取应用签名的 SHA1 值" -> navController.navigate("GetAppSignaturesSHA1View")
                    "获取应用签名的 SHA256 值" -> navController.navigate("GetAppSignaturesSHA256View")

                    "获取应用签名的 MD5 值" -> GlobalUtils.showToast(
                        context,
                        "${item}功能开发中"
                    )

                    "获取 App 信息" -> navController.navigate("GetAppInfoView")
                    "获取所有已安装 App 信息" -> navController.navigate("GetAppsInfoView")
                    "获取 Apk 信息" -> navController.navigate("GetApkInfoView")
                    "判断应用是否首次安装" -> navController.navigate("IsFirstTimeInstalledView")
                }
            })
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun PreviewAppView() {
    AppView(navController = rememberNavController())
}