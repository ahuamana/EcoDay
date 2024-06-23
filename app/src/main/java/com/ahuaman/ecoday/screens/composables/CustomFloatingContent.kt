package com.ahuaman.ecoday.screens.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahuaman.ecoday.R

@Composable
fun CustomFloatingContent(
    onClickIdentifyTrash: () -> Unit
){



    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green_primary)),
            onClick = {
                onClickIdentifyTrash()
            }) {
            Row {
                Text(stringResource(R.string.identify_trash_description_home_screen), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(painterResource(id = R.drawable.ic_camera_identify), contentDescription = "Favorite")
            }
        }

    }
}