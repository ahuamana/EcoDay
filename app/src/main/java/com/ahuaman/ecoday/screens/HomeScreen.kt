package com.ahuaman.ecoday.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahuaman.ecoday.data.FakeItemsDays
import com.ahuaman.ecoday.domain.dashboard.DashboardStates
import com.ahuaman.ecoday.domain.home.EDWeekDay
import com.ahuaman.ecoday.screens.composables.SliderImageComposableWithScaleAnim

@Composable
fun HomeScreen(modifier: Modifier = Modifier, dashboardStates: DashboardStates) {
    Column(modifier = modifier) {
        ContentHomeScreen(modifier, dashboardStates)
    }
}


@Composable
fun ContentHomeScreen(modifier: Modifier, dashboardStates: DashboardStates) {
    SliderImageComposableWithScaleAnim(FakeItemsDays.getDays(), dashboardStates)
}


@Preview
@Composable
private fun HomeScreenPrev() {
    val dashboardStates = DashboardStates.default()
    HomeScreen(dashboardStates =  dashboardStates)
}