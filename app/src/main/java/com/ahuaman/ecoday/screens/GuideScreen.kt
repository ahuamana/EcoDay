package com.ahuaman.ecoday.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahuaman.ecoday.screens.composables.TabRow

@Composable
fun GuideScreen(modifier: Modifier = Modifier) {
    /*val tabs = listOf(
        //TabItem(icon = Icons.Default.Home, text = "Tipos de residuos"),
        //TabItem(icon = Icons.Default.Settings, text = "Puntos verdes")
    )*/
    val selectedIndex = remember { mutableIntStateOf(0) }


    Column(modifier = modifier) {
        TabRow()
    }
}


@Preview
@Composable
private fun GuideScreenPrev() {
    GuideScreen()
}