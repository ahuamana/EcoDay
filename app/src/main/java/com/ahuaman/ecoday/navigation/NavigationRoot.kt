package com.ahuaman.ecoday.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahuaman.ecoday.screens.DashboardScreen
import com.ahuaman.ecoday.screens.OnboardingScreen
import com.ahuaman.ecoday.screens.composables.WebViewComposable
import com.ahuaman.ecoday.utils.openUrlIntent
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
            val context = LocalContext.current
            DashboardScreen(modifier = Modifier.fillMaxSize(), onClickMoreInfo = {
                context.openUrlIntent("https://www.facebook.com/MunicipalidaddePichanaqui")
            },
                onIdentifyNewBitmap = {
                    controller.navigate(ScreensRoot.IdentifyTrashScreen)
            })
        }

        composable<ScreensRoot.MoreInfoScreen> {
            Text(text = "More info screen")
        }

        composable<ScreensRoot.IdentifyTrashScreen> {
            Text(text = "Identify trash screen")
        }

    }
}


sealed class ScreensRoot{
    @Serializable
    data object OnboardingScreen : ScreensRoot()

    @Serializable
    data object DashboardScreen : ScreensRoot()

    @Serializable
    data class MoreInfoScreen(val url: String) : ScreensRoot()

    @Serializable
    data object IdentifyTrashScreen : ScreensRoot()
}

