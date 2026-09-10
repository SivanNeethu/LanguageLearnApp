package com.example.data

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("linguakids_prefs", Context.MODE_PRIVATE)

    var currentGrade: Int
        get() = prefs.getInt(KEY_GRADE, 1)
        set(value) = prefs.edit().putInt(KEY_GRADE, value).apply()

    var preferredLanguage: String
        get() = prefs.getString(KEY_LANGUAGE, "both") ?: "both"
        set(value) = prefs.edit().putString(KEY_LANGUAGE, value).apply()

    var totalXp: Int
        get() = prefs.getInt(KEY_TOTAL_XP, 120)
        set(value) = prefs.edit().putInt(KEY_TOTAL_XP, value).apply()

    var streakDays: Int
        get() = prefs.getInt(KEY_STREAK, 3)
        set(value) = prefs.edit().putInt(KEY_STREAK, value).apply()

    var audioSpeed: Float
        get() = prefs.getFloat(KEY_AUDIO_SPEED, 0.85f)
        set(value) = prefs.edit().putFloat(KEY_AUDIO_SPEED, value).apply()

    fun getCompletedWorksheets(): Set<String> {
        return prefs.getStringSet(KEY_COMPLETED_WORKSHEETS, emptySet()) ?: emptySet()
    }

    fun markWorksheetCompleted(id: String, earnedXp: Int) {
        val current = getCompletedWorksheets().toMutableSet()
        current.add(id)
        prefs.edit().putStringSet(KEY_COMPLETED_WORKSHEETS, current).apply()
        addXp(earnedXp)
    }

    fun getUnlockedStickers(): Set<String> {
        return prefs.getStringSet(KEY_UNLOCKED_STICKERS, setOf("first_step", "varnamala_explorer", "daily_spark")) ?: emptySet()
    }

    fun unlockSticker(id: String) {
        val current = getUnlockedStickers().toMutableSet()
        current.add(id)
        prefs.edit().putStringSet(KEY_UNLOCKED_STICKERS, current).apply()
    }

    fun getReadStories(): Set<String> {
        return prefs.getStringSet(KEY_READ_STORIES, setOf("story_1")) ?: emptySet()
    }

    fun markStoryRead(id: String) {
        val current = getReadStories().toMutableSet()
        if (!current.contains(id)) {
            current.add(id)
            prefs.edit().putStringSet(KEY_READ_STORIES, current).apply()
            addXp(75)
            // check story achievements
            if (current.size >= 1) unlockSticker("story_explorer")
            if (current.size >= 5) unlockSticker("bookworm")
            if (current.size >= 10) unlockSticker("story_sage")
        }
    }

    fun getFavoriteStories(): Set<String> {
        return prefs.getStringSet(KEY_FAVORITE_STORIES, emptySet()) ?: emptySet()
    }

    fun toggleStoryFavorite(id: String) {
        val current = getFavoriteStories().toMutableSet()
        if (current.contains(id)) current.remove(id) else current.add(id)
        prefs.edit().putStringSet(KEY_FAVORITE_STORIES, current).apply()
    }

    fun addXp(amount: Int) {
        val updated = totalXp + amount
        totalXp = updated
        checkLevelStickers(updated)
    }

    private fun checkLevelStickers(xp: Int) {
        if (xp >= 250) unlockSticker("curious_cub")
        if (xp >= 500) unlockSticker("word_explorer")
        if (xp >= 1000) unlockSticker("language_champion")
        if (xp >= 1500) unlockSticker("lingua_guru")
    }

    companion object {
        private const val KEY_GRADE = "pref_current_grade"
        private const val KEY_LANGUAGE = "pref_language"
        private const val KEY_TOTAL_XP = "pref_total_xp"
        private const val KEY_STREAK = "pref_streak"
        private const val KEY_AUDIO_SPEED = "pref_audio_speed"
        private const val KEY_COMPLETED_WORKSHEETS = "pref_completed_worksheets"
        private const val KEY_UNLOCKED_STICKERS = "pref_unlocked_stickers"
        private const val KEY_READ_STORIES = "pref_read_stories"
        private const val KEY_FAVORITE_STORIES = "pref_favorite_stories"
    }
}
