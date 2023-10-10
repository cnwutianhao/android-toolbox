package com.tyhoo.android.toolbox

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class AppStatusChangeListener(
    private val listener: AppStatusChangedListener
) : LifecycleObserver {

    private var isRegistered = true

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        if (isRegistered) {
            listener.onAppForeground()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        if (isRegistered) {
            listener.onAppBackground()
        }
    }

    fun register() {
        isRegistered = true
    }

    fun unregister() {
        isRegistered = false
    }
}

interface AppStatusChangedListener {
    fun onAppForeground()
    fun onAppBackground()
}