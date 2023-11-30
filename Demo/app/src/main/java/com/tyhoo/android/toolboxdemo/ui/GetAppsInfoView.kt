package com.tyhoo.android.toolboxdemo.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tyhoo.android.toolbox.util.AppUtils

@Composable
fun GetAppsInfoView() {
    val context = LocalContext.current
    val apps = AppUtils.getAppsInfo(context)

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(apps) { app ->
            Text(text = app.name, style = TextStyle(fontSize = 20.sp))
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun PreviewGetAppsInfoView() {
    GetAppsInfoView()
}