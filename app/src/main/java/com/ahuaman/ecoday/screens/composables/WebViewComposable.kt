package com.ahuaman.ecoday.screens.composables

import android.net.Uri
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewComposable(url: String) {
    val activity = LocalContext.current as? androidx.activity.ComponentActivity
    activity?.let {
        AndroidView(factory = { context ->
            WebView(context).apply {
                this.settings.javaScriptEnabled = true
                this.loadUrl(url)
            }
        })
    }?: throw IllegalStateException("WebViewComposable must be used inside an Activity")
}