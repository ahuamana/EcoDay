package com.ahuaman.ecoday.screens.viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahuaman.ecoday.domain.EDGenerativeModel
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    suspend fun generateContentWithModel(bitmapUri: Bitmap, apiKey: String) = viewModelScope.launch {
        val model = GenerativeModel(
            modelName = EDGenerativeModel.GEMINI_PRO_1_5.name,
            apiKey = apiKey
        )

        val inputContent = content {
            image(bitmapUri)
            text("his is organic or inoganic container, dont use the labels written on the item? The result give me on a JSON format. where include classification, type, percentage in the JSON -- \n" +
                    "\n" +
                    "{\n" +
                    "\"classification\": \"\",\n" +
                    "\"type\": \"\",\n" +
                    "\"percentage\": \"\"\n" +
                    "} \n -- IMPRINT IN ONE LINE\n" )
        }

        val response = model.generateContent(inputContent)
        val responseText = response.text?.replace("\n", "")?.replace("\r", "")
    }
}