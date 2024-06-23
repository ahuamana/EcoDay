package com.ahuaman.ecoday.screens.composables

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.ahuaman.ecoday.BuildConfig
import com.ahuaman.ecoday.R
import com.ahuaman.ecoday.domain.EDGenerativeModel
import com.ahuaman.ecoday.utils.createImageFile
import com.ahuaman.ecoday.utils.checkCameraPermission
import com.ahuaman.ecoday.utils.resizeAndCompressImage
import com.ahuaman.ecoday.utils.toBase64
import com.ahuaman.ecoday.utils.toBitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import java.util.Objects

@Composable
fun CustomFloatingContent(
    onNewPreviewCaptured: (Bitmap) -> Unit,
){

    val context = LocalContext.current

    val cameraLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) { bitmap ->
        bitmap?.let { bitmapUri ->
            onNewPreviewCaptured(bitmapUri)
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            //Handled case when permission is granted
            cameraLauncher.launch(null)
        } else {
            //Handled case when permission is denied
            Toast.makeText(context, "Permiso denegado", Toast.LENGTH_SHORT).show()
        }
    }


    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green_primary)),
            onClick = {
                checkCameraPermission(context, onPermissionSuccess = {
                    cameraLauncher.launch(null)
                }, onFailPermission = {
                    permissionLauncher.launch(android.Manifest.permission.CAMERA)
                })
            }) {
            Row {
                Text(stringResource(R.string.identify_trash_description_home_screen), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(painterResource(id = R.drawable.ic_camera_identify), contentDescription = "Favorite")
            }
        }

    }
}