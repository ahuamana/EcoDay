package com.ahuaman.ecoday.data

import com.ahuaman.ecoday.domain.home.ItemDayInformation

object FakeItemsDays {

    fun getDays(): List<ItemDayInformation> {
        return listOf(
            ItemDayInformation("Lunes", true),
            ItemDayInformation("Martes", false),
            ItemDayInformation("Miércoles", true),
            ItemDayInformation("Jueves", false),
            ItemDayInformation("Viernes", true),
            ItemDayInformation("Sábado", false),
        )
    }
}