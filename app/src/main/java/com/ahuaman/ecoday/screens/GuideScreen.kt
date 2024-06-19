package com.ahuaman.ecoday.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahuaman.ecoday.screens.composables.TabRow

@Composable
fun GuideScreen(
    modifier: Modifier = Modifier,
    onClickMoreInfo: () -> Unit
    ) {
    Column(modifier = modifier) {
        TabRow(onClickMoreInfo = onClickMoreInfo)
    }
}


@Preview
@Composable
private fun GuideScreenPrev() {
    GuideScreen(onClickMoreInfo = {})
}