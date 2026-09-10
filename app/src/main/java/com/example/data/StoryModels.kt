package com.example.data

data class StoryParagraph(
    val index: Int,
    val hindi: String,
    val hindiTranslit: String,
    val kannada: String,
    val kannadaTranslit: String,
    val english: String,
    val malayalam: String = "",
    val malayalamTranslit: String = ""
)

data class StoryMoral(
    val hindi: String,
    val hindiTranslit: String,
    val kannada: String,
    val kannadaTranslit: String,
    val english: String,
    val malayalam: String = "",
    val malayalamTranslit: String = ""
)

data class Story(
    val id: String,
    val number: Int,
    val titleEnglish: String,
    val titleHindi: String,
    val titleHindiTranslit: String,
    val titleKannada: String,
    val titleKannadaTranslit: String,
    val titleMalayalam: String = "",
    val titleMalayalamTranslit: String = "",
    val category: String,
    val cbseClass: Int,
    val durationMinutes: Int,
    val coverEmoji: String,
    val summary: String,
    val paragraphs: List<StoryParagraph>,
    val moral: StoryMoral,
    val characters: List<String>
)
