package com.ahuaman.ecoday.screens.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahuaman.ecoday.R

@Composable
fun TabRow(
    modifier: Modifier = Modifier,
    onClickMoreInfo: () -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabItem = listOf(
        TabItem(title = "Tipos de residuos", unSelectedItem = R.drawable.ic_type_wasted, selectedIcon =  R.drawable.ic_type_wasted),
        TabItem(title = "Puntos verdes", unSelectedItem = R.drawable.ic_green_points, selectedIcon = R.drawable.ic_green_points)
    )

    val pagerState = rememberPagerState {
        tabItem.size
    }

    LaunchedEffect(key1 = selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(key1 = pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            selectedTabIndex = pagerState.currentPage
    }

    Column(modifier = Modifier.fillMaxWidth()) {

        TabRow(selectedTabIndex = selectedTabIndex, indicator = { tabPositions->
            if (selectedTabIndex < tabPositions. size) {
                TabRowDefaults. SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = colorResource(id = R.color.green_primary),
                )
            }
        }) {

            tabItem.forEachIndexed { index, tabItem ->

                val resource = if (index == selectedTabIndex) {
                    painterResource(id = tabItem.selectedIcon)
                } else painterResource(id = tabItem.unSelectedItem)

                val isSelected = selectedTabIndex == index

                Tab(
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = tabItem.title, color = if(isSelected) colorResource(id = R.color.green_primary) else Color.Gray) },
                    icon = { Icon( painter = resource, contentDescription = tabItem.title, tint = if(isSelected) colorResource(id = R.color.green_primary) else Color.Gray) }
                )
            }
        }

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                when (index) {
                    0 -> {
                       Column( modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState())){
                           Spacer(modifier = Modifier.height(28.dp))
                           ItemWaste(
                               name = "Residuos Reciclables",
                               description = "Materiales que pueden ser procesados y reutilizados, ayudando a reducir el impacto ambiental.",
                               days = "Martes - Jueves - Sabado",
                               time = "8:00 am - 6:00 pm",
                               iconWaste = R.drawable.ic_recycle_trash,
                                 onClickMoreInfo = {
                                     onClickMoreInfo()
                                 }
                           )
                           Spacer(modifier = Modifier.height(28.dp))

                           ItemWaste(
                               colorTitle = R.color.brown_primary,
                               name = "Residuos Orgánicos",
                               description = "Residuos biodegradables que pueden convertirse en compost para enriquecer el suelo y las plantas.",
                               days = "Lunes - Miércoles - Viernes",
                               time = "8:00 am - 6:00 pm",
                               iconWaste = R.drawable.ic_organic_trash,
                               onClickMoreInfo = {
                                   onClickMoreInfo()
                               }
                           )

                           Spacer(modifier = Modifier.height(28.dp))

                           ItemWaste(
                               colorTitle = R.color.black,
                               name = "Residuos Desechables",
                               description = "Residuos que no pueden ser reciclados y deben ser eliminados de forma segura.",
                               days = "Martes - Jueves - Sábado",
                               time = "8:00 am - 6:00 pm",
                                 iconWaste = R.drawable.ic_disposable_trash,
                                 onClickMoreInfo = {
                                     onClickMoreInfo()
                                 }
                           )

                           Spacer(modifier = Modifier.height(28.dp))
                       }
                    }
                    1 -> {
                        //TODO: Puntos verdes screen
                        CustomEmptyStateScreen(
                            modifier = Modifier.fillMaxSize(),
                            image = R.drawable.background_box_empty_state,
                            title = "Característica en desarrollo",
                            description = "Estamos trabajando arduamente para traerte esta característica. ¡Mantente atento para las actualizaciones!"
                        )
                    }
                }
            }
        }
    }
}

// Data Class to handle items
data class TabItem(
    val title: String, val unSelectedItem: Int, val selectedIcon: Int
)