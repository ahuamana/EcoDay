package com.ahuaman.ecoday.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.ahuaman.ecoday.domain.home.ItemDayInformation

@Composable
fun CustomCardUnOrganic(
    modifier: Modifier = Modifier,
    item: ItemDayInformation
    ) {
    Card(modifier = modifier, shape = RoundedCornerShape(16.dp)) {
        CardContentUnOrganic(item = item)
    }
}

@Composable
private fun CardContentUnOrganic(item: ItemDayInformation) {
    val isDarkTheme = isSystemInDarkTheme()

    Column {
        Text(
            text = item.day,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.black),
            fontFamily = FontFamily(Font(R.font.opensans_bold)),
            fontSize = 48.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            //Organic or Inorganic or both
            Text(
                text = "Residuos Orgánicos",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black),
                fontFamily = FontFamily(Font(R.font.opensans_bold)),
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(4.dp))
            //times frames
            Text(
                text = "Residuos Reciclables",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.green_secondary),
                fontFamily = FontFamily(Font(R.font.opensans_bold)),
                fontSize = 24.sp
            )

        }


        Spacer(modifier = Modifier.height(16.dp))
        //times frames
        Text(
            text = "8:00am - 6:00pm",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = if(isDarkTheme) Color.White else colorResource(id = R.color.black),
            fontFamily = FontFamily(Font(R.font.opensans_regular)),
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(38.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Image(
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.ic_recycle_trash_can),
                contentDescription = null)

            Image(
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.ic_inorganic_trashed_can),
                contentDescription = null)
        }


        Spacer(modifier = Modifier.height(57.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.take_care_the_environment_description).uppercase(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.green_secondary),
                fontFamily = FontFamily(Font(R.font.opensans_semibold)),
                fontSize = 16.sp
            )

            Image(
                painter = painterResource(id = R.drawable.ic_leaf),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}


@Preview
@Composable
private fun CustomCardOrganicAndInorganicPrev() {

    val item = ItemDayInformation(
        day = "Lunes",
        isOrganic = false,
    )

    CustomCardUnOrganic(modifier = Modifier.fillMaxWidth(),item = item)
}