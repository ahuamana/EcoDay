package com.ahuaman.ecoday.domain.dashboard

import com.ahuaman.ecoday.data.FakeItemsDays
import com.ahuaman.ecoday.domain.ResultContentIdentifyIA
import com.ahuaman.ecoday.utils.UtilsDay

data class DashboardStates(
    val alreadyOpenedDialogFromIAIdentification: Boolean,
    val responseIA: ResultContentIdentifyIA,
    val dialogState: DialogState,
    val currentDay: String,
    val indexPagerHome: Int
){
    companion object {
        private val daysList = FakeItemsDays.getDays()
        private val currentDayName = UtilsDay.getCurrentEDWeekDay().dayName
        private val index = daysList.indexOfFirst { it.day == currentDayName }.let { if (it == -1) 0 else it }

        fun default() = DashboardStates(
            alreadyOpenedDialogFromIAIdentification = false,
            responseIA = ResultContentIdentifyIA(),
            dialogState = DialogState.IDLE,
            currentDay = UtilsDay.getCurrentEDWeekDay().dayName,
            indexPagerHome = index
        )
    }
}

