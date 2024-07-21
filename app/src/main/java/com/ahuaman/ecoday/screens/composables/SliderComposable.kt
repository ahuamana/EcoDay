package com.ahuaman.ecoday.screens.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.ahuaman.ecoday.data.FakeItemsDays
import com.ahuaman.ecoday.domain.dashboard.DashboardStates
import com.ahuaman.ecoday.domain.home.DayInfo
import com.ahuaman.ecoday.domain.home.EDWeekDay
import com.ahuaman.ecoday.domain.home.ItemDayInformation
import com.ahuaman.ecoday.utils.UtilsDay
import java.time.DayOfWeek
import kotlin.math.absoluteValue

@Composable
fun SliderImageComposableWithScaleAnim(
    list: List<ItemDayInformation>,
    dashboardStates: DashboardStates,
) {

    val pageCount by remember {
        mutableStateOf(list)
    }

    val pagerState = rememberPagerState(
        initialPageOffsetFraction = 0f,
        pageCount = { pageCount.size },
        initialPage = dashboardStates.indexPagerHome,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(top = 30.dp, start = 30.dp, end = 30.dp)
        ) { page ->
            // Our page content - Main card with image
            Card(
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        // We animate the alpha, between 50% and 100%
                        alpha = lerp(
                            start = 0.3f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )

                        // We animate the scaleX + scaleY, between 85% and 100%
                        scaleX = lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                        scaleY = lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )

                    }
                    .clip(RoundedCornerShape(10.dp))
                    .shadow(10.dp, shape = RoundedCornerShape(10.dp)),
            ){

                when(pageCount[page].week.weekDay){
                    EDWeekDay.SUNDAY -> {
                        CustomCardNone(itemDayInformation = pageCount[page])
                    }
                    else -> {
                        if(pageCount[page].isOrganic)
                            CustomCardOrganic(item = pageCount[page])
                        else
                            CustomCardUnOrganic(item = pageCount[page])
                    }
                }


            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        EllipsisIndicator(
            currentPage = pagerState.currentPage,
            total = pageCount.size
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun EllipsisIndicator(
    currentPage: Int,
    total: Int,
    activeColor: Color = Color.Black,
    inactiveColor: Color = Color.LightGray
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (i in 0 until total) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(width = 8.dp, height = 8.dp)
                    .background(
                        color = if (i == currentPage) activeColor else inactiveColor,
                        shape = CircleShape
                    )
            )
        }
    }
}

@Preview
@Composable
private fun SliderImageComposableWithScaleAnimPrev() {

    SliderImageComposableWithScaleAnim(FakeItemsDays.getDays(), DashboardStates.default())

}