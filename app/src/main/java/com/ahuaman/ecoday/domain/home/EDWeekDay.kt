package com.ahuaman.ecoday.domain.home

enum class EDWeekDay ( val dayName: String) {
    MONDAY("Lunes"),
    TUESDAY("Martes"),
    WEDNESDAY("Miércoles"),
    THURSDAY("Jueves"),
    FRIDAY("Viernes"),
    SATURDAY("Sábado"),
    SUNDAY("Domingo");

    fun getDayNameED(): String {
        return dayName
    }
}