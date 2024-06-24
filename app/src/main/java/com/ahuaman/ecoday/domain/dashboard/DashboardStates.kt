package com.ahuaman.ecoday.domain.dashboard

data class DashboardStates(
    val alreadyOpenedDialogFromIAIdentification: Boolean,
    val responseFromIA: String,
    val dialogState: DialogState
){
    companion object {
        fun default() = DashboardStates(
            alreadyOpenedDialogFromIAIdentification = false,
            responseFromIA = "",
            dialogState = DialogState.IDLE
        )
    }
}

