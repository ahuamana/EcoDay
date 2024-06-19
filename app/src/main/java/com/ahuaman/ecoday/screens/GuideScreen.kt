package com.ahuaman.ecoday.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahuaman.ecoday.screens.composables.TabRow

@Composable
fun GuideScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        TabRow()
    }
}


@Preview
@Composable
private fun GuideScreenPrev() {
    GuideScreen()
}