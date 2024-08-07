package com.ahuaman.ecoday.navigation

import android.graphics.Bitmap
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahuaman.ecoday.BuildConfig
import com.ahuaman.ecoday.domain.dashboard.DashboardViewIntent
import com.ahuaman.ecoday.screens.DashboardScreen
import com.ahuaman.ecoday.screens.OnboardingScreen
import com.ahuaman.ecoday.screens.composables.WebViewComposable
import com.ahuaman.ecoday.screens.viewmodels.DashboardViewModel
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

            val viewModel = hiltViewModel<DashboardViewModel>()
            val states by viewModel.intent.collectAsStateWithLifecycle()

            val context = LocalContext.current
            DashboardScreen(
                modifier = Modifier.fillMaxSize(),
                dashboardStates = states,
                onClickMoreInfo = { context.openUrlIntent("https://www.facebook.com/MunicipalidaddePichanaqui") },
                onIdentifyNewBitmap = { bitmap: Bitmap ->
                    viewModel.processIntent(DashboardViewIntent.IdentifyTrashIntent(bitmap, BuildConfig.API_KEY))
                },
                onDialogDismissError = {
                    viewModel.processIntent(DashboardViewIntent.CloseDialogIntent)
                },
                onDialogSuccessDismiss = {
                    viewModel.processIntent(DashboardViewIntent.CloseDialogIntent)
                }
            )
        }

        composable<ScreensRoot.MoreInfoScreen> {
            Text(text = "More info screen")
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

}

