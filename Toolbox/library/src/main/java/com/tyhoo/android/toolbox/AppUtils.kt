package com.tyhoo.android.toolbox

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import com.tyhoo.android.toolbox.data.AppInfo

/**
 * EN: Utils about App.
 * CN: App 相关
 *
 * Author: Tyhoo Wu
 * Blog: https://cnwutianhao.github.io
 * GitHub: https://github.com/cnwutianhao
 * Creation date: 2023-10-09
 * Last update date: 2023-10-09
 */
object AppUtils {

    /**
     * EN: Register app status changed listener
     * CN: 注册 App 前后台切换监听器
     */
    fun registerAppStatusChangedListener() {
    }

    /**
     * EN: Unregister app status changed listener
     * CN: 注销 App 前后台切换监听器
     */
    fun unregisterAppStatusChangedListener() {
    }

    /**
     * EN: Install app
     * CN: 安装 App
     */
    fun installApp() {
    }

    /**
     * EN: Uninstall App
     * CN: 卸载 App
     */
    fun uninstallApp() {
    }

    /**
     * EN: Is app installed
     * CN: 判断 App 是否安装
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return true: yes, false: no
     */
    fun isAppInstalled(context: Context, packageName: String?): Boolean {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                pm.getApplicationInfo(pkgName, 0).enabled
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        } ?: return false
    }

    /**
     * EN: Is app root
     * CN: 判断 App 是否有 root 权限
     */
    fun isAppRoot() {
    }

    /**
     * EN: Is debug app
     * CN: 判断 App 是否是 Debug 版本
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return true: yes, false: no
     */
    fun isAppDebug(context: Context, packageName: String?): Boolean {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val ai = pm.getApplicationInfo(pkgName, 0)
                (ai.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        } ?: return false
    }

    /**
     * EN: Is system app
     * CN: 判断 App 是否是系统应用
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return true: yes, false: no
     */
    fun isAppSystem(context: Context, packageName: String?): Boolean {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val ai = pm.getApplicationInfo(pkgName, 0)
                (ai.flags and ApplicationInfo.FLAG_SYSTEM) != 0
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        } ?: return false
    }

    /**
     * EN: Is foreground app
     * CN: 判断 App 是否处于前台
     */
    fun isAppForeground() {
    }

    /**
     * EN: Is app Running
     * CN: 判断 App 是否运行
     */
    fun isAppRunning() {
    }

    /**
     * EN: Launch app
     * CN: 打开 App
     */
    fun launchApp() {
    }

    /**
     * EN: Relaunch app
     * CN: 重启 App
     */
    fun relaunchApp() {
    }

    /**
     * EN: Launch app details settings
     * CN: 打开 App 具体设置
     */
    fun launchAppDetailsSettings() {
    }

    /**
     * EN: Exit app
     * CN: 关闭应用
     */
    fun exitApp() {
    }

    /**
     * EN: Get app icon
     * CN: 获取 App 图标
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's icon
     */
    fun getAppIcon(context: Context, packageName: String?): Drawable? {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val pi = pm.getPackageInfo(pkgName, 0)
                pi?.applicationInfo?.loadIcon(pm)
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                null
            }
        } ?: return null
    }

    /**
     * EN: Get app package name
     * CN: 获取 App 包名
     *
     * @param context Context
     *
     * @return the application's package name
     */
    fun getAppPackageName(context: Context): String {
        return context.packageName
    }

    /**
     * EN: Get app name
     * CN: 获取 App 名称
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's name
     */
    fun getAppName(context: Context, packageName: String?): String {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val pi = pm.getPackageInfo(pkgName, 0)
                pi.applicationInfo.loadLabel(pm).toString()
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                ""
            }
        } ?: return ""
    }

    /**
     * EN: Get app path
     * CN: 获取 App 路径
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's path
     */
    fun getAppPath(context: Context, packageName: String?): String {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val pi = pm.getPackageInfo(pkgName, 0)
                pi.applicationInfo.sourceDir ?: ""
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                ""
            }
        } ?: return ""
    }

    /**
     * EN: Get app version name
     * CN: 获取 App 版本号
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's version name
     */
    fun getAppVersionName(context: Context, packageName: String?): String {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val pi = pm.getPackageInfo(pkgName, 0)
                pi.versionName ?: ""
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                ""
            }
        } ?: return ""
    }

    /**
     * EN: Get app version code
     * CN: 获取 App 版本码
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's version code
     */
    fun getAppVersionCode(context: Context, packageName: String?): Int {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val pi = pm.getPackageInfo(pkgName, 0)
                pi?.versionCode ?: -1
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                -1
            }
        } ?: return -1
    }

    /**
     * EN: Get app min sdk version
     * CN: 获取 App 支持最低系统版本号
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's minimum sdk version code
     */
    fun getAppMinSdkVersion(context: Context, packageName: String?): Int {
        packageName?.let { pkgName ->
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                return -1
            }

            val pm = context.packageManager
            return try {
                val pi = pm.getPackageInfo(pkgName, 0)
                val ai = pi.applicationInfo
                ai.minSdkVersion
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                -1
            }
        } ?: return -1
    }

    /**
     * EN: Get app target sdk version
     * CN: 获取 App 目标系统版本号
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's target sdk version code
     */
    fun getAppTargetSdkVersion(context: Context, packageName: String?): Int {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val pi = pm.getPackageInfo(pkgName, 0)
                val ai = pi.applicationInfo
                ai.targetSdkVersion
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                -1
            }
        } ?: return -1
    }

    /**
     * EN: Get app signatures
     * CN: 获取 App 签名
     */
    fun getAppSignatures() {
    }

    /**
     * EN: Get app signatures SHA1
     * CN: 获取应用签名的的 SHA1 值
     */
    fun getAppSignaturesSHA1() {
    }

    /**
     * EN: Get app signatures SHA256
     * CN: 获取应用签名的的 SHA256 值
     */
    fun getAppSignaturesSHA256() {
    }

    /**
     * EN: Get app signatures MD5
     * CN: 获取应用签名的的 MD5 值
     */
    fun getAppSignaturesMD5() {
    }

    /**
     * EN: Get app info
     * CN: 获取 App 信息
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's information
     */
    fun getAppInfo(context: Context, packageName: String?): AppInfo? {
        packageName?.let { pkgName ->
            val pm = context.packageManager
            return try {
                val pi = pm.getPackageInfo(pkgName, 0)
                val ai = pi.applicationInfo

                val name = ai.loadLabel(pm).toString()
                val icon = ai.loadIcon(pm)
                val packagePath = ai.sourceDir
                val versionName = pi.versionName
                val versionCode = pi.versionCode
                var minSdkVersion = -1
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    minSdkVersion = ai.minSdkVersion
                }
                val targetSdkVersion = ai.targetSdkVersion
                val isSystem = (ApplicationInfo.FLAG_SYSTEM and ai.flags) != 0

                return AppInfo(
                    packageName, name, icon, packagePath, versionName, versionCode,
                    minSdkVersion, targetSdkVersion, isSystem
                )
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                null
            }
        } ?: return null
    }

    /**
     * EN: Get apps info
     * CN: 获取所有已安装 App 信息
     */
    fun getAppsInfo() {
    }

    /**
     * EN: Get apk info
     * CN: 获取 Apk 信息
     */
    fun getApkInfo() {
    }

    /**
     * EN: Is first time installed
     * CN: 判断应用是否首次安装
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return true: yes, false: no
     */
    fun isFirstTimeInstalled(context: Context, packageName: String?): Boolean {
        packageName?.let { pkgName ->
            return try {
                val pi = context.packageManager.getPackageInfo(pkgName, 0)
                pi.firstInstallTime == pi.lastUpdateTime
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                true
            }
        } ?: return true
    }
}
