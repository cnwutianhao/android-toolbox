package com.tyhoo.android.toolboxdemo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.tyhoo.android.toolbox.AppUtils

@Composable
fun UnregisterAppStatusChangedListenerView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "注销 App 前后台切换监听器",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }

    AppUtils.unregisterAppStatusChangedListener()
}

@Preview
@Composable
fun PreviewUnregisterAppStatusChangedListenerView() {
    UnregisterAppStatusChangedListenerView()
}