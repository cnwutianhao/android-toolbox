package com.tyhoo.android.toolbox

import android.app.ActivityManager
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.lifecycle.ProcessLifecycleOwner
import com.tyhoo.android.toolbox.data.AppInfo

/**
 * Utils about App,
 * App 相关
 *
 * <pre>
 *      Author: Tyhoo Wu
 *      Blog: https://cnwutianhao.github.io
 *      GitHub: https://github.com/cnwutianhao
 *      Creation date: 2023-10-09
 *      Last update date: 2023-10-10
 * </pre>
 */
object AppUtils {

    private lateinit var appStatusChangeListener: AppStatusChangeListener

    /**
     * Register app status changed listener,
     * 注册 App 前后台切换监听器
     *
     * @param listener The status of application changed listener
     */
    fun registerAppStatusChangedListener(listener: AppStatusChangedListener) {
        appStatusChangeListener = AppStatusChangeListener(listener)
        appStatusChangeListener.register()
        ProcessLifecycleOwner.get().lifecycle.addObserver(appStatusChangeListener)
    }

    /**
     * Unregister app status changed listener,
     * 注销 App 前后台切换监听器
     */
    fun unregisterAppStatusChangedListener() {
        if (::appStatusChangeListener.isInitialized) {
            appStatusChangeListener.unregister()
        }
    }

    /**
     * Install app,
     * 安装 App
     */
    fun installApp() {
    }

    /**
     * Uninstall App,
     * 卸载 App
     */
    fun uninstallApp() {
    }

    /**
     * Is app installed,
     * 判断 App 是否安装
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return true: yes, false: no
     */
    fun isAppInstalled(context: Context, packageName: String?): Boolean {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                pm.getApplicationInfo(pkgName, 0).enabled
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        } ?: return false
    }

    /**
     * Is app root,
     * 判断 App 是否有 root 权限
     */
    fun isAppRoot() {
    }

    /**
     * Is debug app,
     * 判断 App 是否是 Debug 版本
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return true: yes, false: no
     */
    fun isAppDebug(context: Context, packageName: String?): Boolean {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                val ai = pm.getApplicationInfo(pkgName, 0)
                (ai.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        } ?: return false
    }

    /**
     * Is system app,
     * 判断 App 是否是系统应用
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return true: yes, false: no
     */
    fun isAppSystem(context: Context, packageName: String?): Boolean {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                val ai = pm.getApplicationInfo(pkgName, 0)
                (ai.flags and ApplicationInfo.FLAG_SYSTEM) != 0
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        } ?: return false
    }

    /**
     * Is foreground app,
     * 判断 App 是否处于前台
     */
    fun isAppForeground(context: Context, packageName: String?): Boolean {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        val appProcesses = activityManager.runningAppProcesses
        if (appProcesses != null) {
            for (processInfo in appProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND &&
                    processInfo.processName == packageName
                ) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * Is app Running,
     * 判断 App 是否运行
     */
    fun isAppRunning() {
    }

    /**
     * Launch app,
     * 打开 App
     */
    fun launchApp() {
    }

    /**
     * Relaunch app,
     * 重启 App
     */
    fun relaunchApp() {
    }

    /**
     * Launch app details settings,
     * 打开 App 具体设置
     */
    fun launchAppDetailsSettings() {
    }

    /**
     * Exit app,
     * 关闭应用
     */
    fun exitApp() {
    }

    /**
     * Get app icon,
     * 获取 App 图标
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's icon
     */
    fun getAppIcon(context: Context, packageName: String?): Drawable? {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                val pi = pm.getPackageInfo(pkgName, 0)
                pi?.applicationInfo?.loadIcon(pm)
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                null
            }
        } ?: return null
    }

    /**
     * Get app package name,
     * 获取 App 包名
     *
     * @param context Context
     *
     * @return the application's package name
     */
    fun getAppPackageName(context: Context): String {
        return context.packageName
    }

    /**
     * Get app name,
     * 获取 App 名称
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's name
     */
    fun getAppName(context: Context, packageName: String?): String {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                val pi = pm.getPackageInfo(pkgName, 0)
                pi.applicationInfo.loadLabel(pm).toString()
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                ""
            }
        } ?: return ""
    }

    /**
     * Get app path,
     * 获取 App 路径
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's path
     */
    fun getAppPath(context: Context, packageName: String?): String {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                val pi = pm.getPackageInfo(pkgName, 0)
                pi.applicationInfo.sourceDir ?: ""
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                ""
            }
        } ?: return ""
    }

    /**
     * Get app version name,
     * 获取 App 版本号
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's version name
     */
    fun getAppVersionName(context: Context, packageName: String?): String {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                val pi = pm.getPackageInfo(pkgName, 0)
                pi.versionName ?: ""
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                ""
            }
        } ?: return ""
    }

    /**
     * Get app version code,
     * 获取 App 版本码
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's version code
     */
    fun getAppVersionCode(context: Context, packageName: String?): Int {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                val pi = pm.getPackageInfo(pkgName, 0)
                pi?.versionCode ?: -1
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                -1
            }
        } ?: return -1
    }

    /**
     * Get app min sdk version,
     * 获取 App 支持最低系统版本号
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

            return try {
                val pm = context.packageManager
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
     * Get app target sdk version,
     * 获取 App 目标系统版本号
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's target sdk version code
     */
    fun getAppTargetSdkVersion(context: Context, packageName: String?): Int {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
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
     * Get app signatures,
     * 获取 App 签名
     */
    fun getAppSignatures() {
    }

    /**
     * Get app signatures SHA1,
     * 获取应用签名的的 SHA1 值
     */
    fun getAppSignaturesSHA1() {
    }

    /**
     * Get app signatures SHA256,
     * 获取应用签名的的 SHA256 值
     */
    fun getAppSignaturesSHA256() {
    }

    /**
     * Get app signatures MD5,
     * 获取应用签名的的 MD5 值
     */
    fun getAppSignaturesMD5() {
    }

    /**
     * Get app info,
     * 获取 App 信息
     *
     * @param context     Context
     * @param packageName The name of the package
     *
     * @return the application's information
     */
    fun getAppInfo(context: Context, packageName: String?): AppInfo? {
        packageName?.let { pkgName ->
            return try {
                val pm = context.packageManager
                val pi = pm.getPackageInfo(pkgName, 0)
                val ai = pi.applicationInfo

                val name = ai.loadLabel(pm).toString()
                val icon = ai.loadIcon(pm)
                val packagePath = ai.sourceDir
                val versionName = pi.versionName
                val versionCode = pi.versionCode
                val minSdkVersion =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) ai.minSdkVersion else -1
                val targetSdkVersion = ai.targetSdkVersion
                val isSystem = (ApplicationInfo.FLAG_SYSTEM and ai.flags) != 0

                AppInfo(
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
     * Get apps info,
     * 获取所有已安装 App 信息
     *
     * @param context     Context
     *
     * @return the applications' information
     */
    fun getAppsInfo(context: Context): List<AppInfo> {
        val pm = context.packageManager
        val installedPackages = pm.getInstalledPackages(0)

        return installedPackages.mapNotNull { pi ->
            val ai = pi.applicationInfo ?: return@mapNotNull null

            val packageName = pi.packageName
            val name = ai.loadLabel(pm).toString()
            val icon = ai.loadIcon(pm)
            val packagePath = ai.sourceDir
            val versionName = pi.versionName
            val versionCode = pi.versionCode
            val minSdkVersion =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) ai.minSdkVersion else -1
            val targetSdkVersion = ai.targetSdkVersion
            val isSystem = (ApplicationInfo.FLAG_SYSTEM and ai.flags) != 0

            AppInfo(
                packageName, name, icon, packagePath, versionName, versionCode,
                minSdkVersion, targetSdkVersion, isSystem
            )
        }
    }

    /**
     * Get apk info,
     * 获取 Apk 信息
     *
     * @return the application's package information
     */
    fun getApkInfo(context: Context, apkFilePath: String): AppInfo? {
        if (apkFilePath.isEmpty()) {
            return null
        }
        val pm = context.packageManager
        val pi = pm.getPackageArchiveInfo(apkFilePath, 0)

        val appInfo = pi?.applicationInfo
        return appInfo?.let { info ->
            info.sourceDir = apkFilePath
            info.publicSourceDir = apkFilePath

            val ai = pi.applicationInfo

            val packageName = pi.packageName
            val name = ai.loadLabel(pm).toString()
            val icon = ai.loadIcon(pm)
            val packagePath = ai.sourceDir
            val versionName = pi.versionName
            val versionCode = pi.versionCode
            val minSdkVersion =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) ai.minSdkVersion else -1
            val targetSdkVersion = ai.targetSdkVersion
            val isSystem = (ApplicationInfo.FLAG_SYSTEM and ai.flags) != 0

            AppInfo(
                packageName, name, icon, packagePath, versionName, versionCode,
                minSdkVersion, targetSdkVersion, isSystem
            )
        }
    }

    /**
     * Is first time installed,
     * 判断应用是否首次安装
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
