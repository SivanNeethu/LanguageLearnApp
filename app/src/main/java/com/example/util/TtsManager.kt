package com.example.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.Locale

class TtsManager(private val context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    var isInitialized by mutableStateOf(false)
        private set
    var isSpeaking by mutableStateOf(false)
        private set
    var currentUtteranceId by mutableStateOf<String?>(null)
        private set
    var speechRate by mutableFloatStateOf(0.85f)
        private set

    init {
        tts = TextToSpeech(context.applicationContext, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isInitialized = true
            tts?.setSpeechRate(speechRate)
            tts?.setPitch(1.05f)
            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    isSpeaking = true
                    currentUtteranceId = utteranceId
                }

                override fun onDone(utteranceId: String?) {
                    isSpeaking = false
                    currentUtteranceId = null
                }

                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) {
                    isSpeaking = false
                    currentUtteranceId = null
                }

                override fun onError(utteranceId: String?, errorCode: Int) {
                    isSpeaking = false
                    currentUtteranceId = null
                    Log.w("TtsManager", "TTS error code: $errorCode for utterance $utteranceId")
                }
            })
        }
    }

    fun setSpeed(rate: Float) {
        speechRate = rate
        tts?.setSpeechRate(rate)
    }

    fun speak(text: String, languageCode: String = "hi", utteranceId: String = "utt_${System.currentTimeMillis()}") {
        if (!isInitialized || text.isBlank()) return

        val resolvedCode = when {
            languageCode.lowercase() in listOf("ml", "malayalam") -> "ml"
            languageCode.lowercase() in listOf("kn", "kannada") -> "kn"
            languageCode.lowercase() in listOf("hi", "hindi") -> "hi"
            text.any { it in '\u0D00'..'\u0D7F' } -> "ml"
            text.any { it in '\u0C80'..'\u0CFF' } -> "kn"
            text.any { it in '\u0900'..'\u097F' } -> "hi"
            else -> languageCode.lowercase()
        }

        val locale = when (resolvedCode) {
            "hi", "hindi" -> Locale("hi", "IN")
            "kn", "kannada" -> Locale("kn", "IN")
            "ml", "malayalam" -> Locale("ml", "IN")
            "en", "english" -> Locale("en", "IN")
            else -> Locale.US
        }

        val result = tts?.setLanguage(locale)
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            // Fallback to English TTS for reading transliterations
            tts?.setLanguage(Locale.US)
        }

        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
        isSpeaking = true
    }

    fun stop() {
        tts?.stop()
        isSpeaking = false
        currentUtteranceId = null
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
    }
}
