package com.ahuaman.ecoday.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahuaman.ecoday.R
import com.ahuaman.ecoday.domain.home.DayInfo
import com.ahuaman.ecoday.domain.home.EDWeekDay
import com.ahuaman.ecoday.domain.home.ItemDayInformation

@Composable
fun CustomCardNone(
    modifier: Modifier = Modifier,
    itemDayInformation: ItemDayInformation
    ) {
    Card(modifier = modifier, shape = RoundedCornerShape(16.dp)) {
        CardContentNone(itemDayInformation)
    }
}

@Composable
private fun CardContentNone(itemDayInformation: ItemDayInformation) {
    val isDarkTheme = isSystemInDarkTheme()

    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {

            Text(
                text = itemDayInformation.week.weekDay.name,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black),
                fontFamily = FontFamily(Font(R.font.opensans_bold)),
                fontSize = 48.sp
            )

            Spacer(modifier = Modifier.height(16.dp))


            CustomEmptyStateScreen(
                image = R.drawable.ic_coffee_empty,
                title = "Recolección no disponible",
                description = "La recolección de basura funciona de lunes a sábado. Por favor, planifica tus actividades teniendo esto en cuenta."
            )

        }

    }


}


@Preview
@Composable
private fun CustomCardOrganicAndInorganicPrev() {

    val itemDayInformation = ItemDayInformation(
        day = "DOMINGO",
        week = DayInfo(EDWeekDay.SUNDAY),
        isOrganic = true
    )

    CustomCardNone(modifier = Modifier.fillMaxWidth(), itemDayInformation = itemDayInformation)
}