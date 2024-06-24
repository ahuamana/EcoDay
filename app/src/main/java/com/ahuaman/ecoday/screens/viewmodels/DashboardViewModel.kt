package com.ahuaman.ecoday.screens.viewmodels

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahuaman.ecoday.BuildConfig
import com.ahuaman.ecoday.domain.EDGenerativeModel
import com.ahuaman.ecoday.domain.ResultContentIdentifyIA
import com.ahuaman.ecoday.domain.dashboard.DashboardStates
import com.ahuaman.ecoday.domain.dashboard.DashboardViewIntent
import com.ahuaman.ecoday.domain.dashboard.DialogState
import com.ahuaman.ecoday.utils.fromJson
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
        val currentState = _intent.value
        _intent.value = currentState.copy(dialogState = DialogState.ERROR)
    }

    private val _intent = MutableStateFlow(DashboardStates.default())
    val intent = _intent.asStateFlow()

    fun processIntent(intent: DashboardViewIntent) = viewModelScope.launch(handler) {
        when(intent) {
            is DashboardViewIntent.IdentifyTrashIntent -> {
                generateContentWithModel(intent.bitmap, intent.apiKey)
            }
            is DashboardViewIntent.CloseDialogIntent -> {
                val currentState = _intent.value
                _intent.value = currentState.copy(dialogState = DialogState.IDLE)
            }
        }
    }

    private suspend fun generateContentWithModel(bitmap: Bitmap, apiKey: String) = viewModelScope.launch( Dispatchers.IO + handler) {
        val currentState = _intent.value
        val loading = currentState.copy(dialogState = DialogState.LOADING)
        _intent.value = loading

        withTimeoutOrNull(5000L){

            val model = GenerativeModel(
                modelName = EDGenerativeModel.GEMINI_PRO_1_5.value,
                apiKey = BuildConfig.API_KEY
            )
            val inputContent = content {
                image(bitmap)
                text("his is organic or inoganic container, dont use the labels written on the item? The result give me on a JSON format and in Spanish. where include classification, type, percentage in the JSON format like this-- \n" +
                        "\n" +
                        "{\n" +
                        "\"classification\": \"\",\n" +
                        "\"type\": \"\",\n" +
                        "\"percentage\": \"\"\n" +
                        "} \n -- IMPRINT IN ONE LINE\n" )
            }
            val response = model.generateContent(inputContent)
            Log.d("response", response.text?:"")
            val responseText = response.text?.replace("\n", "")?.replace("\r", "")
            val responseGson = responseText?.fromJson<ResultContentIdentifyIA>()

            Log.d("responseGson", responseGson.toString())
            _intent.value = currentState.copy(responseIA = responseGson?: ResultContentIdentifyIA(), dialogState = DialogState.SUCCESS)
        }.let { timeout ->
            if (timeout == null) {
                _intent.value = currentState.copy(dialogState = DialogState.ERROR)
            }
        }
    }
}