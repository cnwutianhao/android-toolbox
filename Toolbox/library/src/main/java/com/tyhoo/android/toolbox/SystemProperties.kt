package com.tyhoo.android.toolbox

import android.annotation.SuppressLint
import android.util.Log
import java.lang.reflect.Method

object SystemProperties {

    @SuppressLint("PrivateApi")
    fun get(key: String, defaultValue: String): String {
        return try {
            val systemProperties = Class.forName("android.os.SystemProperties")
            val get: Method =
                systemProperties.getMethod("get", String::class.java, String::class.java)
            get.invoke(null, key, defaultValue) as String
        } catch (e: Exception) {
            // This should never happen
            Log.e("Tyhoo", "Exception while getting system property: ", e)
            defaultValue
        }
    }
}