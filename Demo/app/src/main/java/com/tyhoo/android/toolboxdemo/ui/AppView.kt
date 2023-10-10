package com.tyhoo.android.toolboxdemo.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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
            ClickableText(text = AnnotatedString(item), onClick = {
                if (item == "判断 App 是否安装") {
                    navController.navigate("IsAppInstalledView")
                } else {
                    GlobalUtils.showToast(context, "功能开发中")
                }
            })
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun PreviewAppView() {
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
            Text(text = item)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}