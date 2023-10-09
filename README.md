# Android Toolbox

**[Android Toolbox](https://central.sonatype.com/artifact/io.github.cnwutianhao/AndroidToolbox)** is a powerful & easy to use library for Android.

## Download

build.gradle:
```groovy
implementation 'io.github.cnwutianhao:AndroidToolbox:1.0.1'
```

build.gradle.kts:
```kotlin
implementation("io.github.cnwutianhao:AndroidToolbox:1.0.1")
```

## APIs

* ### App 相关 -> [AppUtils.kt](https://github.com/cnwutianhao/android-toolbox/blob/main/Toolbox/library/src/main/java/com/tyhoo/android/toolbox/AppUtils.kt)
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
launchAppDetailsSettings          : 打开 App 具体设置
exitApp                           : 关闭应用
getAppIcon                        : 获取 App 图标
getAppPackageName                 : 获取 App 包名
getAppName                        : 获取 App 名称
getAppPath                        : 获取 App 路径
getAppVersionName                 : 获取 App 版本号
getAppVersionCode                 : 获取 App 版本码
getAppMinSdkVersion               : 获取 App 支持最低系统版本号
getAppTargetSdkVersion            : 获取 App 目标系统版本号
getAppSignatures                  : 获取 App 签名
getAppSignaturesSHA1              : 获取应用签名的的 SHA1 值
getAppSignaturesSHA256            : 获取应用签名的的 SHA256 值
getAppSignaturesMD5               : 获取应用签名的的 MD5 值
getAppInfo                        : 获取 App 信息
getAppsInfo                       : 获取所有已安装 App 信息
getApkInfo                        : 获取 Apk 信息
isFirstTimeInstalled              : 判断应用是否首次安装
```

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
