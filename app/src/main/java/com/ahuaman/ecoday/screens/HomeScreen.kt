package com.ahuaman.ecoday.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ContentHomeScreen()
    }
}


@Composable
fun ContentHomeScreen(modifier: Modifier = Modifier) {

}


@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}