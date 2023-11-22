package com.tyhoo.android.toolboxdemo.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.tyhoo.android.toolbox.AppStatusChangedListener
import com.tyhoo.android.toolbox.AppUtils

@Composable
fun RegisterAppStatusChangedListenerView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "注册 App 前后台切换监听器",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }

    val context = LocalContext.current

    AppUtils.registerAppStatusChangedListener(object : AppStatusChangedListener {
        override fun onAppBackground() {
            Toast.makeText(context, "App在后台", Toast.LENGTH_SHORT).show()
        }

        override fun onAppForeground() {
            Toast.makeText(context, "App在前台", Toast.LENGTH_SHORT).show()
        }
    })
}

@Preview
@Composable
fun PreviewRegisterAppStatusChangedListenerView() {
    RegisterAppStatusChangedListenerView()
}