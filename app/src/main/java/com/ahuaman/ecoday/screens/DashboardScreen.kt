package com.ahuaman.ecoday.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ahuaman.ecoday.R

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = ScreensDashboard.items

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

                val isSelected = selectedItem == index
                val textColor = if (isSelected) { colorResource(id = R.color.green_primary) } else { Color.Gray }
                val iconColor = if (isSelected) colorResource(id = R.color.green_primary) else Color.Gray

                NavigationBarItem(
                    icon = { Icon(painterResource(id = item.icon), contentDescription = item.title, tint = iconColor) },
                    label = { Text(item.title, color = textColor) },
                    selected = isSelected,
                    onClick = { selectedItem = index }
                )
            }
        }

    }
}

sealed class ScreensDashboard(val route: String, val title: String, @DrawableRes val icon: Int) {
    data object Home :
        ScreensDashboard(route = "Inicio", title = "Inicio", icon = R.drawable.ic_home_filled)

    data object Guide :
        ScreensDashboard(route = "Guía", title = "Guía", icon = R.drawable.ic_guide_filled)

    data object Notifications : ScreensDashboard(
        route = "Notificaciones",
        title = "Notificaciones",
        icon = R.drawable.ic_notification_filled
    )

    companion object {
        val items = listOf(Home, Guide, Notifications)
    }
}


@Preview
@Composable
private fun DashBoardScreenPrev() {
    DashboardScreen()
}