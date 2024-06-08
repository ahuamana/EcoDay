package com.ahuaman.ecoday.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")

    Box(modifier = modifier.fillMaxSize()) {

        when (selectedItem) {
            0 -> {

                Text(text = "Songs", modifier = Modifier.fillMaxSize())
            }
            1 -> {
                Text(text = "Artists")
            }
            2 -> {
                Text(text = "Playlists")
            }
        }


        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter)){
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }

    }
}

@Preview
@Composable
private fun DashBoardScreenPrev() {
    DashboardScreen()
}