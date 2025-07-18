package com.ahuaman.ecoday.domain.dashboard

import android.graphics.Bitmap

sealed class DashboardViewIntent{
    data class IdentifyTrashIntent(val bitmap: Bitmap,val apiKey:String) : DashboardViewIntent()
    data object CloseDialogIntent : DashboardViewIntent()
}
