package com.tyhoo.android.toolboxdemo.ui

import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.widget.addTextChangedListener
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.tyhoo.android.toolbox.data.AppInfo
import com.tyhoo.android.toolbox.util.AppUtils

/**
 * 获取 App 信息
 */
@Composable
fun GetAppInfoView() {
    val context = LocalContext.current

    var searchText by remember { mutableStateOf("") }
    var searchResultText by remember { mutableStateOf("") }
    var appInfo by remember { mutableStateOf<AppInfo?>(null) }

    Column(modifier = Modifier.padding(8.dp)) {
        AndroidView(factory = { context ->
            EditText(context).apply {
                hint = "输入应用包名"
                setText(searchText)
                addTextChangedListener {
                    searchText = it.toString()
                }
            }
        }, modifier = Modifier.fillMaxWidth())

        Button(
            onClick = {
                searchResultText = if (searchText.isEmpty()) {
                    "请输入应用包名"
                } else {
                    ""
                }

                appInfo = AppUtils.getAppInfo(context, searchText)
            }, modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "查找")
        }

        Text(
            text = searchResultText,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        appInfo?.let { info ->
            Image(
                painter = rememberDrawablePainter(drawable = info.icon),
                contentDescription = "App Icon",
                modifier = Modifier
                    .size(100.dp)
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = info.name,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = info.packageName,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = info.packagePath,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = info.versionName,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = info.versionCode.toString(),
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = info.minSdkVersion.toString(),
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = info.targetSdkVersion.toString(),
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = info.isSystem.toString(),
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun PreviewGetAppInfoView() {
    GetAppInfoView()
}