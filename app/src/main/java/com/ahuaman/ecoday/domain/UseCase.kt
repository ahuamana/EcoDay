package com.ahuaman.ecoday.domain

interface UseCase<REQUEST, RESULT> {
    suspend fun execute(input:REQUEST, onResult: (RESULT) -> Unit)
}