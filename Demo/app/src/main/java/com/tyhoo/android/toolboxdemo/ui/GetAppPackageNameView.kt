package com.tyhoo.android.toolboxdemo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tyhoo.android.toolbox.AppUtils

/**
 * 获取 App 包名
 */
@Composable
fun GetAppPackageNameView() {
    val context = LocalContext.current

    var searchResultText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(8.dp)) {
        Button(
            onClick = {
                searchResultText = AppUtils.getAppPackageName(context)
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "获取包名")
        }

        Text(
            text = searchResultText,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun PreviewGetAppPackageNameView() {
    GetAppPackageNameView()
}