package com.tyhoo.android.toolboxdemo.ui

import android.widget.EditText
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.widget.addTextChangedListener
import com.tyhoo.android.toolbox.util.AppUtils

/**
 * 判断 App 是否是 Debug 版本
 */
@Composable
fun IsAppDebugView() {
    val context = LocalContext.current

    var searchText by remember { mutableStateOf("") }
    var searchResultText by remember { mutableStateOf("") }

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
                    if (AppUtils.isAppDebug(context, searchText)) {
                        "App 是 Debug 版本"
                    } else {
                        "App 不是 Debug 版本"
                    }
                }
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
    }
}

@Preview
@Composable
fun PreviewIsAppDebugView() {
    IsAppDebugView()
}