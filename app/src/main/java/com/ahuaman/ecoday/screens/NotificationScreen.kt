package com.ahuaman.ecoday.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahuaman.ecoday.R
import com.ahuaman.ecoday.screens.composables.CustomEmptyStateScreen

@Composable
fun NotificationScreen(modifier: Modifier = Modifier) {
    CustomEmptyStateScreen(
        modifier = modifier,
        image = R.drawable.background_box_empty_state,
        title = "Característica en desarrollo",
        description = "Estamos trabajando arduamente para traerte esta característica. ¡Mantente atento para las actualizaciones!"
    )
}


@Preview
@Composable
private fun NotificationScreenPrev() {
    NotificationScreen(
        modifier = Modifier.fillMaxSize()
    )
}