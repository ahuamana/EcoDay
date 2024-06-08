package com.ahuaman.ecoday.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahuaman.ecoday.screens.DashboardScreen
import com.ahuaman.ecoday.screens.OnboardingScreen
import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot(modifier: Modifier = Modifier) {
    val controller = rememberNavController()
    NavHost(
        navController = controller,
        startDestination = ScreensRoot.OnboardingScreen
    ) {
        composable<ScreensRoot.OnboardingScreen> {
            OnboardingScreen(clickOnStart = {
                controller.navigate(ScreensRoot.DashboardScreen)
            })
        }
        composable<ScreensRoot.DashboardScreen> {
            DashboardScreen(modifier = Modifier.fillMaxSize())
        }

    }
}


sealed class ScreensRoot{
    @Serializable
    data object OnboardingScreen : ScreensRoot()

    @Serializable
    data object DashboardScreen : ScreensRoot()
}

