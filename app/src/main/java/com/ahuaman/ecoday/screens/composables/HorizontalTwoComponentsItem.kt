package com.ahuaman.ecoday.screens.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalTwoComponentsItem(
    title:String,
    result: String
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray.copy(0.1f),
        )
    ) {
        Row(modifier = Modifier.padding(horizontal = 12.dp)) {
            Text(text = title, modifier = Modifier.weight(0.5f))
            Text(text = ":")
            Text(text = result, modifier = Modifier.weight(0.5f), textAlign = TextAlign.End)
        }
    }
}

@Preview
@Composable
private fun HorizontalTwoComponentsItemPreview() {
    HorizontalTwoComponentsItem("Material", "Plástico")
}