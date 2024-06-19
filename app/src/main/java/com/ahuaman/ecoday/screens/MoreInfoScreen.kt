package com.ahuaman.ecoday.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ahuaman.ecoday.screens.composables.WebViewComposable

@Composable
fun MoreInfoScreen(modifier: Modifier = Modifier) {
    WebViewComposable("https://www.ecoday.com.ar/")
}

@Composable
fun GuideScreen(modifier: Modifier = Modifier) {

}