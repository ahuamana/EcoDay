package com.ahuaman.ecoday.screens.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.ahuaman.ecoday.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcoDialogError(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit
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
                            .fillMaxWidth(),painter = painterResource(id = R.drawable.ic_error_ecoday), contentDescription = null, tint = Color.Red)
                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(text = stringResource(R.string.error_message_dialog_error), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.padding(8.dp))
                        Button(onClick = { onDismissRequest() }) {
                            Text(text = stringResource(R.string.button_title_error_dialog))
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
private fun EcoDialogErrorPreview() {
    EcoDialogError(onDismissRequest = {})
}