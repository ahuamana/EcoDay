package com.ahuaman.ecoday.data

import com.ahuaman.ecoday.domain.home.DayInfo
import com.ahuaman.ecoday.domain.home.EDWeekDay
import com.ahuaman.ecoday.domain.home.ItemDayInformation

object FakeItemsDays {

    fun getDays(): List<ItemDayInformation> {
        return listOf(
            ItemDayInformation(EDWeekDay.MONDAY.dayName, true, DayInfo(EDWeekDay.MONDAY)),
            ItemDayInformation(EDWeekDay.TUESDAY.dayName, false, DayInfo(EDWeekDay.TUESDAY)),
            ItemDayInformation(EDWeekDay.WEDNESDAY.dayName, true, DayInfo(EDWeekDay.WEDNESDAY)),
            ItemDayInformation(EDWeekDay.THURSDAY.dayName, false, DayInfo(EDWeekDay.THURSDAY)),
            ItemDayInformation(EDWeekDay.FRIDAY.dayName, true, DayInfo(EDWeekDay.FRIDAY)),
            ItemDayInformation(EDWeekDay.SATURDAY.dayName, false, DayInfo(EDWeekDay.SATURDAY)),
            ItemDayInformation(EDWeekDay.SUNDAY.dayName, true, DayInfo(EDWeekDay.SUNDAY))
        )
    }
}