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
fun HomeView(navController: NavHostController) {
    val context = LocalContext.current
    val items = listOf(
        "Activity 相关",
        "App 相关",
        "亮度相关",
        "转换相关",
        "设备相关",
        "编码解码相关",
        "加密解密相关",
        "文件相关"
    )
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(items) { item ->
            Text(
                text = item,
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier.clickable {
                    when (item) {
                        "App 相关" -> navController.navigate("AppView")
                        "设备相关" -> navController.navigate("DeviceView")
                        else -> GlobalUtils.showToast(context, "功能开发中")
                    }
                }
            )
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun PreviewHomeView() {
    HomeView(navController = rememberNavController())
}