package com.ahuaman.ecoday.utils

import android.content.Intent
import android.net.Uri
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun WebViewWithFileUpload(
    activity: ComponentActivity,
    url: String
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webChromeClient = customWebChromeClient()
                loadUrl(url)
            }
        }
    )
}

private fun customWebChromeClient(): WebChromeClient {
    val webChromeClient = object : WebChromeClient() {
        override fun onShowFileChooser(
            webView: WebView,
            filePathCallback: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            openFileChooser(filePathCallback)
            return true
        }
    }
    return webChromeClient
}

private fun openFileChooser(filePathCallback: ValueCallback<Array<Uri>>) {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*"
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
}