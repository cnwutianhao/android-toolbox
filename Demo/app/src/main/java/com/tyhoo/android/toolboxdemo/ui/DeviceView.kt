package com.tyhoo.android.toolboxdemo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tyhoo.android.toolbox.util.DeviceUtils

@Composable
fun DeviceView() {
    val context = LocalContext.current

    // 判断设备是否 rooted
    val isDeviceRooted = DeviceUtils.isDeviceRooted()
    // 判断设备 ADB 是否可用
    val isADBEnabled = DeviceUtils.isADBEnabled(context)
    // 获取设备系统版本号
    val getSDKVersionName = DeviceUtils.getSDKVersionName()
    // 获取设备系统版本码
    val getSDKVersionCode = DeviceUtils.getSDKVersionCode()
    // 获取设备 AndroidID
    val getAndroidID = DeviceUtils.getAndroidID(context)
    // 获取设备 MAC 地址（未实现）
    val getMacAddress = DeviceUtils.getMacAddress()
    // 获取设备厂商
    val getManufacturer = DeviceUtils.getManufacturer()
    // 获取设备型号
    val getModel = DeviceUtils.getModel()
    // 获取设备 ABIs
    val getABIs = DeviceUtils.getABIs()
    // 判断是否是平板
    val isTablet = DeviceUtils.isTablet()
    // 判断是否是模拟器（未实现）
    val isEmulator = DeviceUtils.isEmulator()
    // 开发者选项是否打开
    val isDevelopmentSettingsEnabled = DeviceUtils.isDevelopmentSettingsEnabled(context)
    // 获取唯一设备 ID（未实现）
    val getUniqueDeviceId = DeviceUtils.getUniqueDeviceId()
    // 获取设备总内存大小（单位：字节）
    val getTotalMemorySize = DeviceUtils.getTotalMemorySize(context)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "设备是否 rooted：$isDeviceRooted",
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "设备 ADB 是否可用：$isADBEnabled",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "设备系统版本号：$getSDKVersionName",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "设备系统版本码：$getSDKVersionCode",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "设备 AndroidID：$getAndroidID",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "设备 MAC 地址：未实现",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "设备厂商：$getManufacturer",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "设备型号：$getModel",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "设备 ABIs：${getABIs[0]}",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "是否是平板：$isTablet",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "是否是模拟器：未实现",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "开发者选项是否打开：$isDevelopmentSettingsEnabled",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "唯一设备 ID：未实现",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = "设备总内存大小：$getTotalMemorySize",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewDeviceView() {
    DeviceView()
}