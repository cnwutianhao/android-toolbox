package com.tyhoo.android.toolbox.util

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.provider.Settings
import java.io.File

/**
 * Utils about Device,
 * 设备相关
 *
 * <pre>
 *      Author: Tyhoo Wu
 *      Blog: https://cnwutianhao.github.io
 *      GitHub: https://github.com/cnwutianhao
 *      Creation date: 2023-11-23
 *      Last update date: 2023-11-29
 * </pre>
 */
object DeviceUtils {

    /**
     * Whether device is rooted,
     * 判断设备是否 rooted
     *
     * @return true: yes, false: no
     */
    fun isDeviceRooted(): Boolean {
        val su = "su"
        val locations = listOf(
            "/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/",
            "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/",
            "/data/local/", "/system/sbin/", "/usr/bin/", "/vendor/bin/"
        )

        return locations.any { location ->
            File(location + su).exists()
        }
    }

    /**
     * Whether ADB is enabled.,
     * 判断设备 ADB 是否可用
     *
     * @return true: yes, false: no
     */
    fun isADBEnabled(context: Context): Boolean = Settings.Secure.getInt(
        context.contentResolver,
        Settings.Global.ADB_ENABLED,
        0
    ) > 0

    /**
     * Get the version name of device's system,
     * 获取设备系统版本号
     *
     * @return the version name of device's system
     */
    fun getSDKVersionName(): String = android.os.Build.VERSION.RELEASE

    /**
     * Get the version code of device's system,
     * 获取设备系统版本码
     *
     * @return version code of device's system
     */
    fun getSDKVersionCode(): Int = android.os.Build.VERSION.SDK_INT

    /**
     * Get the android id of device,
     * 获取设备 AndroidID
     *
     * 注：厂商定制系统的Bug：不同的设备可能会产生相同的ANDROID_ID：9774d56d682e549c。
     *    厂商定制系统的Bug：有些设备返回的值为null。
     *
     * @return the android id of device
     */
    @SuppressLint("HardwareIds")
    fun getAndroidID(context: Context): String {
        val id = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        if ("9774d56d682e549c" == id) {
            return ""
        }
        return id ?: ""
    }

    /**
     * Get the MAC address,
     * 获取设备 MAC 地址
     *
     * @return the MAC address
     */
    fun getMacAddress(): String {
        return ""
    }

    /**
     * Get the manufacturer of the product/hardware,
     * 获取设备厂商
     *
     * @return the manufacturer of the product/hardware
     */
    fun getManufacturer(): String = android.os.Build.MANUFACTURER

    /**
     * Get the model of device,
     * 获取设备型号
     *
     * @return the model of device
     */
    fun getModel(): String {
        var model = android.os.Build.MODEL
        model = model?.trim()?.replace("\\s*".toRegex(), "") ?: ""
        return model
    }

    /**
     * Get an ordered list of ABIs supported by this device,
     * 获取设备 ABIs
     *
     * @return an ordered list of ABIs supported by this device
     */
    fun getABIs(): Array<String> = android.os.Build.SUPPORTED_ABIS

    /**
     * Whether device is tablet,
     * 判断是否是平板
     *
     * @return true: yes, false: no
     */
    fun isTablet(): Boolean = ((Resources.getSystem().configuration.screenLayout
            and Configuration.SCREENLAYOUT_SIZE_MASK)
            >= Configuration.SCREENLAYOUT_SIZE_LARGE)

    /**
     * Whether device is emulator,
     * 判断是否是模拟器
     *
     * @return true: yes, false: no
     */
    fun isEmulator(): Boolean {
        return true
    }

    /**
     * Whether user has enabled development settings,
     * 开发者选项是否打开
     *
     * @return whether user has enabled development settings.
     */
    fun isDevelopmentSettingsEnabled(context: Context): Boolean = Settings.Global.getInt(
        context.contentResolver,
        Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
        0
    ) > 0

    /**
     * Get the unique device id,
     * 获取唯一设备 ID
     *
     * @return the unique device id
     */
    fun getUniqueDeviceId(): String {
        return ""
    }

    /**
     * Get the total device memory size,
     * 获取设备总内存大小（单位：字节）
     *
     * @return the total memory size
     */
    fun getTotalMemorySize(context: Context): Long {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val mi = ActivityManager.MemoryInfo()
        am.getMemoryInfo(mi)
        return mi.totalMem
    }
}