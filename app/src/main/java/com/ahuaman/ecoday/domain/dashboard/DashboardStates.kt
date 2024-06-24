package com.ahuaman.ecoday.domain.dashboard

import com.ahuaman.ecoday.domain.ResultContentIdentifyIA

data class DashboardStates(
    val alreadyOpenedDialogFromIAIdentification: Boolean,
    val responseIA: ResultContentIdentifyIA,
    val dialogState: DialogState
){
    companion object {
        fun default() = DashboardStates(
            alreadyOpenedDialogFromIAIdentification = false,
            responseIA = ResultContentIdentifyIA(),
            dialogState = DialogState.IDLE
        )
    }
}

