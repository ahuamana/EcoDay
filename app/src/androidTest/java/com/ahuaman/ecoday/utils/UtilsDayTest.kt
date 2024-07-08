package com.ahuaman.ecoday.utils

import com.ahuaman.ecoday.domain.home.EDWeekDay
import org.junit.Assert.*
import org.junit.Test

class UtilsDayTest {

    @Test
    fun getCurrentEDWeekDay() {
        // Arrange
        val weekDay = EDWeekDay.SUNDAY
        // Act
        val result = UtilsDay.getCurrentEDWeekDay()

        // Assert
        assertEquals(weekDay, result)

    }


}