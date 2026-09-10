package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CurriculumData
import com.example.data.LetterItem
import com.example.data.UserPreferences
import com.example.data.VocabWord
import com.example.ui.theme.AmberLight
import com.example.ui.theme.AmberSecondary
import com.example.ui.theme.HindiLight
import com.example.ui.theme.HindiSaffron
import com.example.ui.theme.IndigoLight
import com.example.ui.theme.IndigoPrimary
import com.example.ui.theme.KannadaCrimson
import com.example.ui.theme.KannadaLight
import com.example.ui.theme.MalayalamEmerald
import com.example.ui.theme.MalayalamLight
import com.example.util.TtsManager

@Composable
fun LessonsScreen(
    preferences: UserPreferences,
    ttsManager: TtsManager,
    initialTab: Int = 0,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(initialTab) }
    var selectedLanguage by remember { mutableStateOf(preferences.preferredLanguage) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    var selectedGrade by remember { mutableIntStateOf(preferences.currentGrade) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("lessons_screen")
    ) {
        // Top Bar & Tab Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 4.dp)
        ) {
            Text(
                text = "CBSE Lessons & Words",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = IndigoPrimary
            )
            Text(
                text = "Script + English transliteration + Audio guides",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.Transparent
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = {
                        Text(
                            text = "Alphabets (वर्णमाला/ವರ್ಣಮಾಲೆ/അക്ഷരമാല)",
                            fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = {
                        Text(
                            text = "Vocabulary (शब्दावली)",
                            fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    }
                )
            }
        }

        if (selectedTab == 0) {
            // Alphabets View
            AlphabetsView(
                ttsManager = ttsManager,
                selectedLanguage = selectedLanguage,
                onLanguageChange = { selectedLanguage = it }
            )
        } else {
            // Vocabulary View
            VocabularyView(
                ttsManager = ttsManager,
                searchQuery = searchQuery,
                onSearchChange = { searchQuery = it },
                selectedCategory = selectedCategory,
                onCategoryChange = { selectedCategory = it },
                selectedGrade = selectedGrade,
                onGradeChange = { selectedGrade = it }
            )
        }
    }
}

@Composable
fun AlphabetsView(
    ttsManager: TtsManager,
    selectedLanguage: String,
    onLanguageChange: (String) -> Unit
) {
    var langMode by remember {
        mutableStateOf(
            when (selectedLanguage) {
                "kannada" -> "kannada"
                "malayalam" -> "malayalam"
                else -> "hindi"
            }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Language Toggle Bar (3 Languages)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = if (langMode == "hindi") HindiSaffron else HindiLight,
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        langMode = "hindi"
                        onLanguageChange("hindi")
                    }
            ) {
                Box(
                    modifier = Modifier.padding(vertical = 9.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "हिंदी Hindi",
                        color = if (langMode == "hindi") Color.White else HindiSaffron,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = if (langMode == "kannada") KannadaCrimson else KannadaLight,
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        langMode = "kannada"
                        onLanguageChange("kannada")
                    }
            ) {
                Box(
                    modifier = Modifier.padding(vertical = 9.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "ಕನ್ನಡ Kannada",
                        color = if (langMode == "kannada") Color.White else KannadaCrimson,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = if (langMode == "malayalam") MalayalamEmerald else MalayalamLight,
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        langMode = "malayalam"
                        onLanguageChange("malayalam")
                    }
            ) {
                Box(
                    modifier = Modifier.padding(vertical = 9.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "മലയാളം Malayalam",
                        color = if (langMode == "malayalam") Color.White else MalayalamEmerald,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }
        }

        // Informative tip banner
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 2.dp),
            shape = RoundedCornerShape(10.dp),
            color = AmberLight.copy(alpha = 0.5f)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "💡", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Tap any letter card to hear real pronunciation with English phonetic hints!",
                    fontSize = 11.sp,
                    color = Color(0xFF92400E)
                )
            }
        }

        val letterList = when (langMode) {
            "hindi" -> CurriculumData.hindiLetters
            "kannada" -> CurriculumData.kannadaLetters
            else -> CurriculumData.malayalamLetters
        }

        val langLocale = when (langMode) {
            "hindi" -> "hi"
            "kannada" -> "kn"
            else -> "ml"
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 96.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(letterList) { letter ->
                LetterCard(
                    letter = letter,
                    langMode = langMode,
                    onSpeak = {
                        ttsManager.speak(letter.exampleWord, langLocale)
                    }
                )
            }
        }
    }
}

@Composable
fun LetterCard(
    letter: LetterItem,
    langMode: String,
    onSpeak: () -> Unit
) {
    val badgeColor = when (langMode) {
        "hindi" -> HindiLight
        "kannada" -> KannadaLight
        else -> MalayalamLight
    }
    val accentColor = when (langMode) {
        "hindi" -> HindiSaffron
        "kannada" -> KannadaCrimson
        else -> MalayalamEmerald
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.clickable { onSpeak() }
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = badgeColor
                ) {
                    Text(
                        text = letter.transliteration,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                IconButton(
                    onClick = onSpeak,
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Speak letter",
                        tint = accentColor,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Big Script Letter
            Text(
                text = letter.script,
                fontSize = 42.sp,
                fontWeight = FontWeight.ExtraBold,
                color = accentColor
            )

            Text(
                text = letter.englishSound,
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Example Word
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFFF8FAFC),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = letter.emoji, fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = letter.exampleWord,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Text(
                        text = "${letter.exampleWordTransliteration} (${letter.exampleMeaning})",
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}

@Composable
fun VocabularyView(
    ttsManager: TtsManager,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    selectedCategory: String,
    onCategoryChange: (String) -> Unit,
    selectedGrade: Int,
    onGradeChange: (Int) -> Unit
) {
    val filteredList = CurriculumData.vocabularyList.filter { word ->
        val matchesCategory = selectedCategory == "All" || word.category.equals(selectedCategory, ignoreCase = true)
        val matchesGrade = selectedGrade == 0 || word.cbseClass <= selectedGrade
        val matchesSearch = searchQuery.isBlank() ||
                word.english.contains(searchQuery, ignoreCase = true) ||
                word.hindiScript.contains(searchQuery) ||
                word.hindiTransliteration.contains(searchQuery, ignoreCase = true) ||
                word.kannadaScript.contains(searchQuery) ||
                word.kannadaTransliteration.contains(searchQuery, ignoreCase = true) ||
                word.malayalamScript.contains(searchQuery) ||
                word.malayalamTransliteration.contains(searchQuery, ignoreCase = true)

        matchesCategory && matchesGrade && matchesSearch
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Search Input
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            placeholder = { Text("Search word, meaning, or transliteration...", fontSize = 13.sp) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            trailingIcon = {
                if (searchQuery.isNotBlank()) {
                    IconButton(onClick = { onSearchChange("") }) {
                        Icon(Icons.Default.Close, contentDescription = "Clear")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp)
        )

        // Grade Filter Chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            listOf(0 to "All Classes", 1 to "Class 1", 2 to "Class 2", 3 to "Class 3", 4 to "Class 4").forEach { (gr, label) ->
                FilterChip(
                    selected = selectedGrade == gr,
                    onClick = { onGradeChange(gr) },
                    label = { Text(label, fontSize = 11.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = IndigoPrimary,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }

        // Category Chips
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(CurriculumData.categories) { cat ->
                FilterChip(
                    selected = selectedCategory == cat,
                    onClick = { onCategoryChange(cat) },
                    label = { Text(cat, fontSize = 12.sp) }
                )
            }
        }

        // List of Vocab Cards
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredList) { word ->
                VocabCardItem(word = word, ttsManager = ttsManager)
            }
        }
    }
}

@Composable
fun VocabCardItem(
    word: VocabWord,
    ttsManager: TtsManager
) {
    ElevatedCard(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header: Emoji + English + Class Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(AmberLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = word.emoji, fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = word.english,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = word.category,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.55f)
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = IndigoLight
                ) {
                    Text(
                        text = "Class ${word.cbseClass}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = IndigoPrimary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Hindi Section
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = HindiLight.copy(alpha = 0.6f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "हिंदी: ",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = HindiSaffron
                            )
                            Text(
                                text = word.hindiScript,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF7C2D12)
                            )
                        }
                        Text(
                            text = "Pronounce: \"${word.hindiTransliteration}\"",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = HindiSaffron
                        )
                        if (word.hindiExample.isNotBlank()) {
                            Text(
                                text = "Ex: ${word.hindiExample} (${word.hindiExampleTranslit})",
                                fontSize = 10.sp,
                                color = Color(0xFF7C2D12).copy(alpha = 0.8f),
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }

                    IconButton(
                        onClick = { ttsManager.speak(word.hindiScript, "hi") },
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Hear Hindi",
                            tint = HindiSaffron
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Kannada Section
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = KannadaLight.copy(alpha = 0.6f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "ಕನ್ನಡ: ",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = KannadaCrimson
                            )
                            Text(
                                text = word.kannadaScript,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF881337)
                            )
                        }
                        Text(
                            text = "Pronounce: \"${word.kannadaTransliteration}\"",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = KannadaCrimson
                        )
                        if (word.kannadaExample.isNotBlank()) {
                            Text(
                                text = "Ex: ${word.kannadaExample} (${word.kannadaExampleTranslit})",
                                fontSize = 10.sp,
                                color = Color(0xFF881337).copy(alpha = 0.8f),
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }

                    IconButton(
                        onClick = { ttsManager.speak(word.kannadaScript, "kn") },
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Hear Kannada",
                            tint = KannadaCrimson
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Malayalam Section
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MalayalamLight.copy(alpha = 0.6f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "മലയാളം: ",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MalayalamEmerald
                            )
                            Text(
                                text = word.malayalamScript,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF064E3B)
                            )
                        }
                        Text(
                            text = "Pronounce: \"${word.malayalamTransliteration}\"",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MalayalamEmerald
                        )
                    }

                    IconButton(
                        onClick = { ttsManager.speak(word.malayalamScript, "ml") },
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Hear Malayalam",
                            tint = MalayalamEmerald
                        )
                    }
                }
            }
        }
    }
}
