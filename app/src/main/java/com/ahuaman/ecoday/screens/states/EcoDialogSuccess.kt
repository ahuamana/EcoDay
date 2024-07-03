package com.ahuaman.ecoday.screens.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.ahuaman.ecoday.R
import com.ahuaman.ecoday.domain.ResultContentIdentifyIA
import com.ahuaman.ecoday.screens.composables.HorizontalTwoComponentsItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcoDialogSuccess(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    result: ResultContentIdentifyIA,
    ) {
    BasicAlertDialog(
        onDismissRequest = {
            onDismissRequest()
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Black.copy(0.5f)) {}
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                ) {
                    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(modifier = Modifier
                            .fillMaxWidth(),painter = painterResource(id = R.drawable.ic_check_circle), contentDescription = null, tint = colorResource(id = R.color.green_primary))
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(modifier = Modifier.fillMaxWidth(0.8f), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Análisis completado:",
                                modifier = Modifier.fillMaxWidth(0.7f), // Ajusta este valor según tus necesidades
                                textAlign = TextAlign.Start
                            )
                            Column {
                                Spacer(modifier = Modifier.padding(8.dp))
                                HorizontalTwoComponentsItem("Material", result.classification?:"")
                                Spacer(modifier = Modifier.padding(8.dp))
                                HorizontalTwoComponentsItem("Tipo", result.type?:"")
                                Spacer(modifier = Modifier.padding(8.dp))
                                HorizontalTwoComponentsItem("Porcentaje", result.percentage?:"")
                            }
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Button(onClick = { onDismissRequest() }) {
                            Text(text = stringResource(R.string.button_title_success_dialog))
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                    }

                }
            }
        }

    }
}

@Preview
@Composable
private fun EcoDialogSuccessPreview() {
    EcoDialogSuccess(onDismissRequest = {}, result = ResultContentIdentifyIA("Orgánico", "Botella", "90"))
}