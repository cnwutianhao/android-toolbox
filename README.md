# Android Toolbox

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.cnwutianhao/AndroidToolbox/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.cnwutianhao/AndroidToolbox) [![License](https://img.shields.io/:license-mit-blue.svg)](LICENSE) [![API](https://img.shields.io/badge/API-21%2B-red.svg?style=flat)](https://android-arsenal.com/api?level=21) [![Twitter Follow](https://img.shields.io/twitter/follow/tyhoowu.svg?style=social)](https://twitter.com/tyhoowu)


**[Android Toolbox](https://central.sonatype.com/artifact/io.github.cnwutianhao/AndroidToolbox)** is a powerful & easy to use library for Android.

## Download

You can download a aar from GitHub's [releases page](https://github.com/cnwutianhao/android-toolbox/releases).

Or use Gradle:

```gradle
repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation 'io.github.cnwutianhao:AndroidToolbox:1.0.3'
}
```

Or Maven:

```xml
<dependency>
    <groupId>io.github.cnwutianhao</groupId>
    <artifactId>AndroidToolbox</artifactId>
    <version>1.0.3</version>
</dependency>
```

## APIs

* ### App 相关 -> [AppUtils.kt](https://github.com/cnwutianhao/android-toolbox/blob/main/Toolbox/library/src/main/java/com/tyhoo/android/toolbox/util/AppUtils.kt)
```
registerAppStatusChangedListener  : 注册 App 前后台切换监听器
unregisterAppStatusChangedListener: 注销 App 前后台切换监听器
installApp                        : 安装 App
uninstallApp                      : 卸载 App
isAppInstalled                    : 判断 App 是否安装
isAppRoot                         : 判断 App 是否有 root 权限
isAppDebug                        : 判断 App 是否是 Debug 版本
isAppSystem                       : 判断 App 是否是系统应用
isAppForeground                   : 判断 App 是否处于前台
isAppRunning                      : 判断 App 是否运行
launchApp                         : 打开 App
relaunchApp                       : 重启 App
launchAppDetailsSettings          : 打开 App 详情设置页面
exitApp                           : 关闭 App
getAppIcon                        : 获取 App 图标
getAppPackageName                 : 获取 App 包名
getAppName                        : 获取 App 名称
getAppPath                        : 获取 App 路径
getAppVersionName                 : 获取 App 版本号
getAppVersionCode                 : 获取 App 版本码
getAppMinSdkVersion               : 获取 App 支持最低系统版本号
getAppTargetSdkVersion            : 获取 App 目标系统版本号
getAppSignatures                  : 获取 App 签名
getAppSignaturesSHA1              : 获取 App 签名的 SHA1 值
getAppSignaturesSHA256            : 获取 App 签名的 SHA256 值
getAppSignaturesMD5               : 获取 App 签名的 MD5 值
getAppInfo                        : 获取 App 信息
getAppsInfo                       : 获取所有已安装 App 信息
getApkInfo                        : 获取 Apk 信息
isFirstTimeInstalled              : 判断 App 是否首次安装
```

* ### 设备相关 -> [DeviceUtils.kt](https://github.com/cnwutianhao/android-toolbox/blob/main/Toolbox/library/src/main/java/com/tyhoo/android/toolbox/util/DeviceUtils.kt)
```
isDeviceRooted                    : 判断设备是否 rooted
isADBEnabled                      : 判断设备 ADB 是否可用
getSDKVersionName                 : 获取设备系统版本号
getSDKVersionCode                 : 获取设备系统版本码
getAndroidID                      : 获取设备 AndroidID
getMacAddress                     : 获取设备 MAC 地址
getManufacturer                   : 获取设备厂商
getModel                          : 获取设备型号
getABIs                           : 获取设备 ABIs
isTablet                          : 判断是否是平板
isEmulator                        : 判断是否是模拟器
isDevelopmentSettingsEnabled      : 开发者选项是否打开
getUniqueDeviceId                 : 获取唯一设备 ID
getTotalMemorySize                : 获取设备总内存大小（单位：字节）
```

## Star History

[![Star History Chart](https://api.star-history.com/svg?repos=cnwutianhao/android-toolbox&type=Date)](https://star-history.com/#cnwutianhao/android-toolbox&Date)

## Repo Activity

![Repo Activity](https://repobeats.axiom.co/api/embed/5dc25fd2279d8526ff38316d6c26b54d155db06b.svg "Repobeats analytics image")

## License

```
MIT License

Copyright (c) 2023 Tyhoo Wu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
