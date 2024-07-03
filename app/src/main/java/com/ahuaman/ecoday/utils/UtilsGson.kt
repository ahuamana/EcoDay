package com.ahuaman.ecoday.utils

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException


inline fun <reified T> String.fromJson(): T? {
    return try {
        Gson().fromJson(this, T::class.java)
    } catch (e: JsonSyntaxException) {
        null
    }
}