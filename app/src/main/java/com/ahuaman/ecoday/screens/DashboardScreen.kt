package com.ahuaman.ecoday.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ahuaman.ecoday.R
import com.ahuaman.ecoday.screens.composables.CustomFloatingContent
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    onClickMoreInfo: () -> Unit,
    onClickIdentifyTrash: () -> Unit
    ) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = ScreensDashboard.items
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = items[selectedItem].title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontFamily = FontFamily(Font(R.font.opensans_bold)))
            })
        },

        floatingActionButton = {
            if(items[selectedItem] is ScreensDashboard.Home){
                CustomFloatingContent(onClickIdentifyTrash = onClickIdentifyTrash)
            }

        },

        bottomBar = {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val selectedFromDestination = items.indexOfFirst { menu ->
                (menu.javaClass.simpleName == currentDestination?.route?.split(".")?.last())
            }

            NavigationBar{
                items.forEachIndexed { index, item ->
                    val isSelected = if (selectedFromDestination == -1) index == 0 else index == selectedFromDestination
                    val textColor = if (isSelected) { colorResource(id = R.color.green_primary) } else { Color.Gray }
                    val iconColor = if (isSelected) colorResource(id = R.color.green_primary) else Color.Gray

                    NavigationBarItem(
                        icon = { Icon(painterResource(id = item.icon), contentDescription = item.title, tint = iconColor) },
                        label = { Text(item.title, color = textColor) },
                        selected = isSelected,
                        onClick = {
                            //avoid select the same item
                            if (isSelected) return@NavigationBarItem
                            selectedItem = index
                            navController.navigate(item)
                        }
                    )
                }
            }
        },
        content = { innerPadding ->
            NavHost(navController = navController, startDestination = ScreensDashboard.Home, modifier = modifier.padding(innerPadding)) {
                composable<ScreensDashboard.Home> {
                    HomeScreen(modifier = Modifier.fillMaxSize())
                }
                composable<ScreensDashboard.Guide>{
                    GuideScreen(modifier = Modifier.fillMaxSize(), onClickMoreInfo = {
                        onClickMoreInfo()
                    })
                }
                composable<ScreensDashboard.Notifications>{
                    NotificationScreen(modifier = Modifier.fillMaxSize())
                }
            }
        }
    )
}

@Serializable
sealed class ScreensDashboard(val title: String, @DrawableRes val icon: Int) {
    @Serializable
    data object Home :
        ScreensDashboard(title = "Inicio", icon = R.drawable.ic_home_filled)
    @Serializable
    data object Guide :
        ScreensDashboard( title = "Guía", icon = R.drawable.ic_guide_filled)
    @Serializable
    data object Notifications : ScreensDashboard(
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
    DashboardScreen(modifier = Modifier.fillMaxSize(), onClickMoreInfo = {}, onClickIdentifyTrash = {})
}