package com.ahuaman.ecoday.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity

fun Context.openUrlIntent(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    this.startActivity(intent)
}

