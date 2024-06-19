package com.ahuaman.ecoday.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahuaman.ecoday.R
import com.ahuaman.ecoday.utils.openUrlIntent

@Composable
fun ItemWaste(
    modifier: Modifier = Modifier,
    colorTitle:Int = R.color.green_primary,
    iconWaste: Int = R.drawable.ic_recycle_trash,
    name: String,
    description: String,
    days: String,
    time: String,
    onClickMoreInfo: () -> Unit
              ) {
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = name, style = MaterialTheme.typography.titleMedium, color = colorResource(id = colorTitle))
        Text(text = description, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(12.dp))
        ItemDays(days = days , time = time, modifier = Modifier.padding(top = 8.dp), icon = iconWaste, onClickMoreInfo = onClickMoreInfo)
        Spacer(modifier = Modifier.height(12.dp))
        HorizontalDivider(
            color = colorResource(id = colorTitle),
            thickness = 2.dp
        )
    }
}

@Composable
fun ItemDays(
    modifier: Modifier = Modifier,
    days: String,
    time: String,
    isVisibleHours: Boolean = false,
    isVisibleMoreInfo: Boolean = false,
    icon: Int = R.drawable.ic_recycle_trash,
    onClickMoreInfo: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column {


            Column {
                Row {
                    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green_primary))) {
                        Row{
                            Icon(painter = painterResource(id = R.drawable.ic_calendar), contentDescription = null)
                            Spacer(modifier = Modifier.padding(4.dp))
                            Text(text = days)
                        }
                    }
                    //Text(text = days, fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.opensans_regular)))
                }
                if(isVisibleHours) Text(text = time,fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.opensans_regular)))
                Spacer(modifier = Modifier.height(12.dp))

                Button(onClick = {
                    onClickMoreInfo()
                }) {
                    UnderlinedText(text = stringResource(id = R.string.see_more))
                }

            }
        }

        Image(painter = painterResource(id = icon), contentDescription = null)
    }
}

@Composable
fun UnderlinedText(text: String) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.opensans_semibold)),
        style = TextStyle(textDecoration = TextDecoration.Underline)
    )
}

@Preview
@Composable
private fun UnderlinedTextPrev() {
    UnderlinedText("5:00 am - 6:00 pm")
}


@Preview
@Composable
private fun ItemWastePrev() {
    ItemWaste(
        name = "Residuos Reciclables",
        description = "Materiales que pueden ser procesados y reutilizados, ayudando a reducir el impacto ambiental.",
        days = "Lunes - Miércoles - Viernes",
        time = "8:00 am - 12:00 pm",
        onClickMoreInfo = {}
    )
}

@Preview
@Composable
private fun ItemDaysPrev() {
    ItemDays(
        days = "Lunes - Miércoles - Viernes",
        time = "8:00 am - 12:00 pm",
        onClickMoreInfo = {}
    )
}