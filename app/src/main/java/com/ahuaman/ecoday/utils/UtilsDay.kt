package com.ahuaman.ecoday.utils

import com.ahuaman.ecoday.domain.home.EDWeekDay
import java.time.ZoneId
import java.time.ZonedDateTime

object UtilsDay {

    fun getCurrentEDWeekDay(): EDWeekDay {
        val zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Lima"))
        val dayOfWeek = zonedDateTime.dayOfWeek.value
        return when(dayOfWeek) {
            1 -> EDWeekDay.MONDAY
            2 -> EDWeekDay.TUESDAY
            3 -> EDWeekDay.WEDNESDAY
            4 -> EDWeekDay.THURSDAY
            5 -> EDWeekDay.FRIDAY
            6 -> EDWeekDay.SATURDAY
            7 -> EDWeekDay.SUNDAY
            else -> EDWeekDay.MONDAY
        }
    }

}