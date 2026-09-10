package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.StoriesData
import com.example.data.Story
import com.example.data.UserPreferences
import com.example.ui.components.ConfettiOverlay
import com.example.ui.theme.AmberDark
import com.example.ui.theme.AmberLight
import com.example.ui.theme.AmberSecondary
import com.example.ui.theme.GreenLight
import com.example.ui.theme.HindiLight
import com.example.ui.theme.HindiSaffron
import com.example.ui.theme.IndigoLight
import com.example.ui.theme.IndigoPrimary
import com.example.ui.theme.KannadaCrimson
import com.example.ui.theme.KannadaLight
import com.example.ui.theme.MalayalamEmerald
import com.example.ui.theme.MalayalamLight
import com.example.ui.theme.PurpleFun
import com.example.ui.theme.PurpleLight
import com.example.util.TtsManager

@Composable
fun StoriesScreen(
    preferences: UserPreferences,
    ttsManager: TtsManager,
    initialStoryId: String? = null,
    modifier: Modifier = Modifier
) {
    var activeStory by remember {
        mutableStateOf(
            if (initialStoryId != null) {
                StoriesData.allStories.find { it.id == initialStoryId }
            } else null
        )
    }

    var selectedCategory by remember { mutableStateOf("All") }
    var selectedGrade by remember { mutableIntStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }
    var showOnlyFavorites by remember { mutableStateOf(false) }

    if (activeStory != null) {
        TrilingualStoryReader(
            story = activeStory!!,
            preferences = preferences,
            ttsManager = ttsManager,
            onBack = {
                ttsManager.stop()
                activeStory = null
            },
            modifier = modifier
        )
    } else {
        StoriesCatalogView(
            preferences = preferences,
            selectedCategory = selectedCategory,
            onCategoryChange = { selectedCategory = it },
            selectedGrade = selectedGrade,
            onGradeChange = { selectedGrade = it },
            searchQuery = searchQuery,
            onSearchChange = { searchQuery = it },
            showOnlyFavorites = showOnlyFavorites,
            onToggleFavorites = { showOnlyFavorites = !showOnlyFavorites },
            onSelectStory = { activeStory = it },
            modifier = modifier
        )
    }
}

@Composable
fun StoriesCatalogView(
    preferences: UserPreferences,
    selectedCategory: String,
    onCategoryChange: (String) -> Unit,
    selectedGrade: Int,
    onGradeChange: (Int) -> Unit,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    showOnlyFavorites: Boolean,
    onToggleFavorites: () -> Unit,
    onSelectStory: (Story) -> Unit,
    modifier: Modifier = Modifier
) {
    val readStories = preferences.getReadStories()
    val favorites = preferences.getFavoriteStories()

    val filteredStories = StoriesData.allStories.filter { story ->
        val matchesCategory = selectedCategory == "All" || story.category.equals(selectedCategory, ignoreCase = true)
        val matchesGrade = selectedGrade == 0 || story.cbseClass == selectedGrade
        val matchesFav = !showOnlyFavorites || favorites.contains(story.id)
        val matchesSearch = searchQuery.isBlank() ||
                story.titleEnglish.contains(searchQuery, ignoreCase = true) ||
                story.titleHindi.contains(searchQuery) ||
                story.titleHindiTranslit.contains(searchQuery, ignoreCase = true) ||
                story.titleKannada.contains(searchQuery) ||
                story.titleKannadaTranslit.contains(searchQuery, ignoreCase = true) ||
                story.titleMalayalam.contains(searchQuery) ||
                story.titleMalayalamTranslit.contains(searchQuery, ignoreCase = true)

        matchesCategory && matchesGrade && matchesFav && matchesSearch
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("stories_catalog")
    ) {
        // Top Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "300 Multi-Language Stories",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = IndigoPrimary
                        )
                    }
                    Text(
                        text = "10-min CBSE stories in Hindi, Kannada, Malayalam & English",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = PurpleLight
                ) {
                    Text(
                        text = "📖 ${readStories.size}/300 Read",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = PurpleFun,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchChange,
                placeholder = { Text("Search 300 stories by title, moral, theme...", fontSize = 13.sp) },
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
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Language Selection for Stories
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Language:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                val langFilters = listOf(
                    Triple("both", "All Languages", IndigoPrimary),
                    Triple("hindi", "हिंदी Hindi", HindiSaffron),
                    Triple("kannada", "ಕನ್ನಡ Kannada", KannadaCrimson),
                    Triple("malayalam", "മലയാളം Malayalam", MalayalamEmerald)
                )
                langFilters.forEach { (code, label, color) ->
                    val isSelected = preferences.preferredLanguage == code || (code == "both" && preferences.preferredLanguage !in listOf("hindi", "kannada", "malayalam"))
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = if (isSelected) color else color.copy(alpha = 0.08f),
                        modifier = Modifier.clickable {
                            preferences.preferredLanguage = code
                        }
                    ) {
                        Text(
                            text = label,
                            color = if (isSelected) Color.White else color,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Grade Filters
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                listOf(0 to "All Grades", 1 to "Class 1", 2 to "Class 2", 3 to "Class 3", 4 to "Class 4").forEach { (gr, label) ->
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

            // Categories
            LazyRow(
                contentPadding = PaddingValues(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(StoriesData.categories) { cat ->
                    FilterChip(
                        selected = selectedCategory == cat,
                        onClick = { onCategoryChange(cat) },
                        label = { Text(cat, fontSize = 11.sp) }
                    )
                }
            }
        }

        // Story Cards List
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredStories) { story ->
                StoryCatalogCard(
                    story = story,
                    isRead = readStories.contains(story.id),
                    isFavorite = favorites.contains(story.id),
                    onToggleFav = { preferences.toggleStoryFavorite(story.id) },
                    onClick = { onSelectStory(story) }
                )
            }
        }
    }
}

@Composable
fun StoryCatalogCard(
    story: Story,
    isRead: Boolean,
    isFavorite: Boolean,
    onToggleFav: () -> Unit,
    onClick: () -> Unit
) {
    ElevatedCard(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(AmberLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = story.coverEmoji, fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "#${story.number} ",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = IndigoPrimary
                            )
                            Text(
                                text = "${story.category} • ${story.durationMinutes} mins",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                        Text(
                            text = story.titleEnglish,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                IconButton(onClick = onToggleFav) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) AmberDark else Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Script & Transliteration Previews
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFFF8FAFC),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "हिंदी: ",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = HindiSaffron
                        )
                        Text(
                            text = "${story.titleHindi} (${story.titleHindiTranslit})",
                            fontSize = 12.sp,
                            color = Color(0xFF7C2D12),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "ಕನ್ನಡ: ",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = KannadaCrimson
                        )
                        Text(
                            text = "${story.titleKannada} (${story.titleKannadaTranslit})",
                            fontSize = 12.sp,
                            color = Color(0xFF881337),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "മലയാളം: ",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = MalayalamEmerald
                        )
                        Text(
                            text = "${story.titleMalayalam} (${story.titleMalayalamTranslit})",
                            fontSize = 12.sp,
                            color = Color(0xFF064E3B),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = IndigoLight
                    ) {
                        Text(
                            text = "CBSE Class ${story.cbseClass}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = IndigoPrimary,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }
                    if (isRead) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = GreenLight
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = Color(0xFF15803D),
                                    modifier = Modifier.size(12.dp)
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    text = "Finished",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF15803D)
                                )
                            }
                        }
                    }
                }

                Text(
                    text = "Read & Speak →",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = IndigoPrimary
                )
            }
        }
    }
}

@Composable
fun TrilingualStoryReader(
    story: Story,
    preferences: UserPreferences,
    ttsManager: TtsManager,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var storyLanguage by remember {
        mutableStateOf(
            when (preferences.preferredLanguage) {
                "kannada" -> "kannada"
                "malayalam" -> "malayalam"
                "english" -> "english"
                else -> "hindi"
            }
        )
    }
    var showTransliteration by remember { mutableStateOf(true) }
    var showEnglishParallel by remember { mutableStateOf(true) }
    var fontSizeMultiplier by remember { mutableFloatStateOf(1.0f) }
    var showCelebration by remember { mutableStateOf(false) }

    val readStories = preferences.getReadStories()
    val isAlreadyRead = readStories.contains(story.id)

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8FAFC)),
            contentPadding = PaddingValues(bottom = 120.dp)
        ) {
            // Header Bar
            item {
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    shadowElevation = 2.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = onBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Story #${story.number} • ${story.category}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = IndigoPrimary
                                )
                                Text(
                                    text = story.titleEnglish,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            // Font size toggle
                            IconButton(
                                onClick = {
                                    fontSizeMultiplier = if (fontSizeMultiplier >= 1.3f) 1.0f else fontSizeMultiplier + 0.15f
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.FormatSize,
                                    contentDescription = "Change font size",
                                    tint = IndigoPrimary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // 4-Way Language Switcher Tabs
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            val tabs = listOf(
                                Triple("hindi", "हिंदी (Hindi)", HindiSaffron),
                                Triple("kannada", "ಕನ್ನಡ (Kannada)", KannadaCrimson),
                                Triple("malayalam", "മലയാളം (Malayalam)", MalayalamEmerald),
                                Triple("english", "English", IndigoPrimary)
                            )
                            tabs.forEach { (code, label, color) ->
                                val selected = storyLanguage == code
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = if (selected) color else color.copy(alpha = 0.08f),
                                    modifier = Modifier
                                        .clickable {
                                            storyLanguage = code
                                            ttsManager.stop()
                                        }
                                ) {
                                    Box(
                                        modifier = Modifier.padding(vertical = 9.dp, horizontal = 12.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = label,
                                            color = if (selected) Color.White else color,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Audio Player Controls & Options Bar
            item {
                Surface(
                    color = AmberLight.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    shape = CircleShape,
                                    color = if (ttsManager.isSpeaking) Color(0xFFDC2626) else IndigoPrimary,
                                    modifier = Modifier.size(42.dp)
                                ) {
                                    IconButton(
                                        onClick = {
                                            if (ttsManager.isSpeaking) {
                                                ttsManager.stop()
                                            } else {
                                                // Read full story
                                                val textToSpeak = story.paragraphs.joinToString(" ") { p ->
                                                    when (storyLanguage) {
                                                        "hindi" -> p.hindi
                                                        "kannada" -> p.kannada
                                                        "malayalam" -> p.malayalam
                                                        else -> p.english
                                                    }
                                                }
                                                ttsManager.speak(textToSpeak, storyLanguage)
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (ttsManager.isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                                            contentDescription = "Play/Stop Audio",
                                            tint = Color.White
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = if (ttsManager.isSpeaking) "Reading Story Aloud..." else "Listen Story Audio",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = Color(0xFF78350F)
                                    )
                                    Text(
                                        text = "Speed: ${String.format("%.2f", ttsManager.speechRate)}x • 100% Offline TTS",
                                        fontSize = 10.sp,
                                        color = Color(0xFF92400E)
                                    )
                                }
                            }

                            // Speed switch button
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = Color.White,
                                modifier = Modifier.clickable {
                                    val newRate = if (ttsManager.speechRate <= 0.75f) 1.0f else 0.75f
                                    ttsManager.setSpeed(newRate)
                                }
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Speed,
                                        contentDescription = "Toggle Speed",
                                        tint = AmberDark,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (ttsManager.speechRate <= 0.75f) "0.75x (Kid)" else "1.0x (Norm)",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AmberDark
                                    )
                                }
                            }
                        }

                        if (storyLanguage != "english") {
                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 8.dp),
                                color = AmberSecondary.copy(alpha = 0.2f)
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "English Transliteration (Pronounce guide):",
                                    fontSize = 11.sp,
                                    color = Color(0xFF78350F),
                                    fontWeight = FontWeight.Medium
                                )
                                Switch(
                                    checked = showTransliteration,
                                    onCheckedChange = { showTransliteration = it },
                                    colors = SwitchDefaults.colors(checkedThumbColor = AmberDark, checkedTrackColor = AmberLight)
                                )
                            }
                        }
                    }
                }
            }

            // Paragraphs
            items(story.paragraphs) { paragraph ->
                StoryParagraphCard(
                    paragraph = paragraph,
                    language = storyLanguage,
                    showTransliteration = showTransliteration,
                    fontSizeMultiplier = fontSizeMultiplier,
                    onSpeak = {
                        val text = when (storyLanguage) {
                            "hindi" -> paragraph.hindi
                            "kannada" -> paragraph.kannada
                            "malayalam" -> paragraph.malayalam
                            else -> paragraph.english
                        }
                        ttsManager.speak(text, storyLanguage)
                    }
                )
            }

            // Moral of the Story Card
            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = AmberLight.copy(alpha = 0.7f)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                        .border(2.dp, AmberDark, RoundedCornerShape(18.dp))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "🌟", fontSize = 24.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Moral of the Story (सीख / ನೀತಿ / ഗുണപാഠം)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF78350F)
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        when (storyLanguage) {
                            "hindi" -> {
                                Text(
                                    text = story.moral.hindi,
                                    fontSize = (16 * fontSizeMultiplier).sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF7C2D12)
                                )
                                if (showTransliteration) {
                                    Text(
                                        text = "Pronounce: \"${story.moral.hindiTranslit}\"",
                                        fontSize = (12 * fontSizeMultiplier).sp,
                                        color = HindiSaffron,
                                        modifier = Modifier.padding(top = 2.dp)
                                    )
                                }
                                Text(
                                    text = "Meaning: ${story.moral.english}",
                                    fontSize = (12 * fontSizeMultiplier).sp,
                                    color = Color(0xFF78350F).copy(alpha = 0.85f),
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                            "kannada" -> {
                                Text(
                                    text = story.moral.kannada,
                                    fontSize = (16 * fontSizeMultiplier).sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF881337)
                                )
                                if (showTransliteration) {
                                    Text(
                                        text = "Pronounce: \"${story.moral.kannadaTranslit}\"",
                                        fontSize = (12 * fontSizeMultiplier).sp,
                                        color = KannadaCrimson,
                                        modifier = Modifier.padding(top = 2.dp)
                                    )
                                }
                                Text(
                                    text = "Meaning: ${story.moral.english}",
                                    fontSize = (12 * fontSizeMultiplier).sp,
                                    color = Color(0xFF78350F).copy(alpha = 0.85f),
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                            "malayalam" -> {
                                Text(
                                    text = story.moral.malayalam,
                                    fontSize = (16 * fontSizeMultiplier).sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF064E3B)
                                )
                                if (showTransliteration) {
                                    Text(
                                        text = "Pronounce: \"${story.moral.malayalamTranslit}\"",
                                        fontSize = (12 * fontSizeMultiplier).sp,
                                        color = MalayalamEmerald,
                                        modifier = Modifier.padding(top = 2.dp)
                                    )
                                }
                                Text(
                                    text = "Meaning: ${story.moral.english}",
                                    fontSize = (12 * fontSizeMultiplier).sp,
                                    color = Color(0xFF78350F).copy(alpha = 0.85f),
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                            else -> {
                                Text(
                                    text = story.moral.english,
                                    fontSize = (15 * fontSizeMultiplier).sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF78350F)
                                )
                            }
                        }
                    }
                }
            }

            // Finish Story Button
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            preferences.markStoryRead(story.id)
                            showCelebration = true
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = if (isAlreadyRead) Color(0xFF16A34A) else IndigoPrimary),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                    ) {
                        Text(
                            text = if (isAlreadyRead) "Story Completed! (+75 XP Earned) 🎉" else "Mark Story as Finished (+75 XP) 🌟",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

        // Confetti celebration
        ConfettiOverlay(
            visible = showCelebration,
            onFinished = { showCelebration = false }
        )
    }
}

@Composable
fun StoryParagraphCard(
    paragraph: com.example.data.StoryParagraph,
    language: String,
    showTransliteration: Boolean,
    fontSizeMultiplier: Float,
    onSpeak: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFF1F5F9)
                ) {
                    Text(
                        text = "¶ ${paragraph.index}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF64748B),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                IconButton(
                    onClick = onSpeak,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Speak paragraph",
                        tint = when (language) {
                            "hindi" -> HindiSaffron
                            "kannada" -> KannadaCrimson
                            "malayalam" -> MalayalamEmerald
                            else -> IndigoPrimary
                        },
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            when (language) {
                "hindi" -> {
                    // Native Hindi Script
                    Text(
                        text = paragraph.hindi,
                        fontSize = (17 * fontSizeMultiplier).sp,
                        lineHeight = (26 * fontSizeMultiplier).sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1E293B)
                    )

                    // English Transliteration
                    if (showTransliteration) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = HindiLight.copy(alpha = 0.5f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Pronounce: ${paragraph.hindiTranslit}",
                                fontSize = (12 * fontSizeMultiplier).sp,
                                lineHeight = (18 * fontSizeMultiplier).sp,
                                color = Color(0xFF9A3412),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }

                    // English Translation
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "English: ${paragraph.english}",
                        fontSize = (13 * fontSizeMultiplier).sp,
                        lineHeight = (19 * fontSizeMultiplier).sp,
                        color = Color(0xFF475569)
                    )
                }

                "kannada" -> {
                    // Native Kannada Script
                    Text(
                        text = paragraph.kannada,
                        fontSize = (17 * fontSizeMultiplier).sp,
                        lineHeight = (26 * fontSizeMultiplier).sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1E293B)
                    )

                    // English Transliteration
                    if (showTransliteration) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = KannadaLight.copy(alpha = 0.5f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Pronounce: ${paragraph.kannadaTranslit}",
                                fontSize = (12 * fontSizeMultiplier).sp,
                                lineHeight = (18 * fontSizeMultiplier).sp,
                                color = Color(0xFF9F1239),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }

                    // English Translation
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "English: ${paragraph.english}",
                        fontSize = (13 * fontSizeMultiplier).sp,
                        lineHeight = (19 * fontSizeMultiplier).sp,
                        color = Color(0xFF475569)
                    )
                }

                "malayalam" -> {
                    // Native Malayalam Script
                    Text(
                        text = paragraph.malayalam,
                        fontSize = (17 * fontSizeMultiplier).sp,
                        lineHeight = (26 * fontSizeMultiplier).sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1E293B)
                    )

                    // English Transliteration
                    if (showTransliteration) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MalayalamLight.copy(alpha = 0.5f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Pronounce: ${paragraph.malayalamTranslit}",
                                fontSize = (12 * fontSizeMultiplier).sp,
                                lineHeight = (18 * fontSizeMultiplier).sp,
                                color = Color(0xFF065F46),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }

                    // English Translation
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "English: ${paragraph.english}",
                        fontSize = (13 * fontSizeMultiplier).sp,
                        lineHeight = (19 * fontSizeMultiplier).sp,
                        color = Color(0xFF475569)
                    )
                }

                else -> {
                    // English
                    Text(
                        text = paragraph.english,
                        fontSize = (16 * fontSizeMultiplier).sp,
                        lineHeight = (24 * fontSizeMultiplier).sp,
                        color = Color(0xFF1E293B)
                    )
                }
            }
        }
    }
}
