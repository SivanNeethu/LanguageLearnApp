package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import com.example.data.QuizOption
import com.example.data.RewardSticker
import com.example.data.StickersData
import com.example.data.UserPreferences
import com.example.data.Worksheet
import com.example.data.WorksheetsData
import com.example.ui.components.ConfettiOverlay
import com.example.ui.theme.AmberDark
import com.example.ui.theme.AmberLight
import com.example.ui.theme.AmberSecondary
import com.example.ui.theme.GreenLight
import com.example.ui.theme.IndigoLight
import com.example.ui.theme.IndigoPrimary
import com.example.ui.theme.PurpleFun
import com.example.ui.theme.PurpleLight
import com.example.util.TtsManager

@Composable
fun WorksheetsScreen(
    preferences: UserPreferences,
    ttsManager: TtsManager,
    modifier: Modifier = Modifier
) {
    var activeWorksheet by remember { mutableStateOf<Worksheet?>(null) }
    var selectedTopTab by remember { mutableIntStateOf(0) } // 0: Worksheets, 1: Reward Stickers

    if (activeWorksheet != null) {
        WorksheetQuizPlayer(
            worksheet = activeWorksheet!!,
            preferences = preferences,
            ttsManager = ttsManager,
            onBack = { activeWorksheet = null },
            modifier = modifier
        )
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .testTag("worksheets_screen")
        ) {
            // Header Bar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 4.dp)
            ) {
                Text(
                    text = "CBSE Worksheets & Stickers",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = IndigoPrimary
                )
                Text(
                    text = "Practice questions, collect stickers & level up!",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f)
                )

                Spacer(modifier = Modifier.height(12.dp))

                TabRow(
                    selectedTabIndex = selectedTopTab,
                    containerColor = Color.Transparent
                ) {
                    Tab(
                        selected = selectedTopTab == 0,
                        onClick = { selectedTopTab = 0 },
                        text = {
                            Text(
                                text = "Worksheets (अभ्यास)",
                                fontWeight = if (selectedTopTab == 0) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 13.sp
                            )
                        }
                    )
                    Tab(
                        selected = selectedTopTab == 1,
                        onClick = { selectedTopTab = 1 },
                        text = {
                            Text(
                                text = "Stickers Album (${preferences.getUnlockedStickers().size})",
                                fontWeight = if (selectedTopTab == 1) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 13.sp
                            )
                        }
                    )
                }
            }

            if (selectedTopTab == 0) {
                WorksheetsCatalogList(
                    preferences = preferences,
                    onSelectWorksheet = { activeWorksheet = it }
                )
            } else {
                StickersAlbumGrid(preferences = preferences)
            }
        }
    }
}

@Composable
fun WorksheetsCatalogList(
    preferences: UserPreferences,
    onSelectWorksheet: (Worksheet) -> Unit
) {
    var selectedGrade by remember { mutableIntStateOf(preferences.currentGrade) }
    val completedWorksheets = preferences.getCompletedWorksheets()

    val filtered = WorksheetsData.worksheets.filter { ws ->
        selectedGrade == 0 || ws.cbseClass == selectedGrade
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Class filters
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            listOf(0 to "All Classes", 1 to "Class 1", 2 to "Class 2", 3 to "Class 3", 4 to "Class 4").forEach { (gr, label) ->
                FilterChip(
                    selected = selectedGrade == gr,
                    onClick = { selectedGrade = gr },
                    label = { Text(label, fontSize = 11.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = IndigoPrimary,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filtered) { worksheet ->
                val isDone = completedWorksheets.contains(worksheet.id)

                ElevatedCard(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelectWorksheet(worksheet) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
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
                                    Text(text = worksheet.icon, fontSize = 22.sp)
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = worksheet.title,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = "${worksheet.topic} • ${worksheet.questions.size} Questions",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                    )
                                }
                            }

                            if (isDone) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = GreenLight
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = Color(0xFF15803D),
                                            modifier = Modifier.size(12.dp)
                                        )
                                        Spacer(modifier = Modifier.width(2.dp))
                                        Text(
                                            text = "Done",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF15803D)
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = worksheet.description,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = AmberLight
                            ) {
                                Text(
                                    text = "+${worksheet.xpReward} XP Reward ⭐",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFB45309),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }

                            Text(
                                text = if (isDone) "Retake Quiz →" else "Start Worksheet →",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = IndigoPrimary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WorksheetQuizPlayer(
    worksheet: Worksheet,
    preferences: UserPreferences,
    ttsManager: TtsManager,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableIntStateOf(0) }
    var isAnswerSubmitted by remember { mutableStateOf(false) }
    var isQuizCompleted by remember { mutableStateOf(false) }
    var showConfetti by remember { mutableStateOf(false) }

    val question = worksheet.questions.getOrNull(currentIndex)

    Box(modifier = modifier.fillMaxSize()) {
        if (isQuizCompleted) {
            // Quiz Results Screen
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "🎉", fontSize = 64.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Worksheet Completed!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = IndigoPrimary
                )
                Text(
                    text = "You scored $score out of ${worksheet.questions.size} correct!",
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = AmberLight,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "+${worksheet.xpReward} XP Added to Your Profile! ⭐",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = Color(0xFFB45309)
                        )
                        Text(
                            text = "New Reward Sticker unlocked in your album!",
                            fontSize = 12.sp,
                            color = Color(0xFF92400E)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(containerColor = IndigoPrimary),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text("Back to Worksheets", fontWeight = FontWeight.Bold)
                }
            }
        } else if (question != null) {
            // Active Question View
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF8FAFC))
            ) {
                // Header
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    shadowElevation = 2.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = onBack) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                            }
                            Column {
                                Text(
                                    text = worksheet.title,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Question ${currentIndex + 1} of ${worksheet.questions.size}",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = AmberLight
                        ) {
                            Text(
                                text = "Score: $score",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB45309),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }

                // Progress Bar
                LinearProgressIndicator(
                    progress = { (currentIndex + 1f) / worksheet.questions.size },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp),
                    color = IndigoPrimary,
                    trackColor = Color(0xFFE2E8F0)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // Question Card
                    item {
                        Card(
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(18.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = question.emoji, fontSize = 48.sp)
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = question.prompt,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = IndigoLight
                                ) {
                                    Text(
                                        text = "💡 Clue: ${question.transliterationClue}",
                                        fontSize = 11.sp,
                                        color = IndigoPrimary,
                                        fontWeight = FontWeight.Medium,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }
                        }
                    }

                    // Options List
                    items(question.options.indices.toList()) { optIndex ->
                        val opt = question.options[optIndex]
                        val isSelected = selectedOptionIndex == optIndex
                        val isCorrect = optIndex == question.correctIndex

                        val containerColor = when {
                            isAnswerSubmitted && isCorrect -> Color(0xFFDCFCE7)
                            isAnswerSubmitted && isSelected && !isCorrect -> Color(0xFFFEE2E2)
                            isSelected -> IndigoLight
                            else -> MaterialTheme.colorScheme.surface
                        }

                        val borderColor = when {
                            isAnswerSubmitted && isCorrect -> Color(0xFF22C55E)
                            isAnswerSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444)
                            isSelected -> IndigoPrimary
                            else -> Color(0xFFE2E8F0)
                        }

                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = containerColor,
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(2.dp, borderColor, RoundedCornerShape(14.dp))
                                .clickable(enabled = !isAnswerSubmitted) {
                                    selectedOptionIndex = optIndex
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(14.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = opt.script,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = "Pronounce: \"${opt.transliteration}\" • English: ${opt.english}",
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f)
                                    )
                                }

                                IconButton(
                                    onClick = { ttsManager.speak(opt.script, "hi") },
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.VolumeUp,
                                        contentDescription = "Speak option",
                                        tint = IndigoPrimary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }

                    // Explanation & Next Button
                    item {
                        if (isAnswerSubmitted) {
                            Card(
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF3C7)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Text(
                                        text = "Explanation:",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = Color(0xFF92400E)
                                    )
                                    Text(
                                        text = question.explanation,
                                        fontSize = 12.sp,
                                        color = Color(0xFF78350F)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        if (!isAnswerSubmitted) {
                            Button(
                                onClick = {
                                    if (selectedOptionIndex != null) {
                                        isAnswerSubmitted = true
                                        if (selectedOptionIndex == question.correctIndex) {
                                            score++
                                        }
                                    }
                                },
                                enabled = selectedOptionIndex != null,
                                colors = ButtonDefaults.buttonColors(containerColor = IndigoPrimary),
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                            ) {
                                Text("Check Answer", fontWeight = FontWeight.Bold)
                            }
                        } else {
                            Button(
                                onClick = {
                                    if (currentIndex + 1 < worksheet.questions.size) {
                                        currentIndex++
                                        selectedOptionIndex = null
                                        isAnswerSubmitted = false
                                    } else {
                                        // Completed!
                                        preferences.markWorksheetCompleted(worksheet.id, worksheet.xpReward)
                                        isQuizCompleted = true
                                        showConfetti = true
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = IndigoPrimary),
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                            ) {
                                Text(
                                    text = if (currentIndex + 1 < worksheet.questions.size) "Next Question →" else "Finish Worksheet 🌟",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }

        ConfettiOverlay(
            visible = showConfetti,
            onFinished = { showConfetti = false }
        )
    }
}

@Composable
fun StickersAlbumGrid(preferences: UserPreferences) {
    val unlocked = preferences.getUnlockedStickers()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Stats banner
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = AmberLight,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "🏆", fontSize = 36.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Sticker Trophy Album",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF78350F)
                    )
                    Text(
                        text = "Collected ${unlocked.size} of ${StickersData.allStickers.size} badges. Finish worksheets and read stories to unlock more!",
                        fontSize = 11.sp,
                        color = Color(0xFF92400E)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(bottom = 96.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(StickersData.allStickers) { sticker ->
                val isUnlocked = unlocked.contains(sticker.id)

                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isUnlocked) MaterialTheme.colorScheme.surface else Color(0xFFF1F5F9)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = if (isUnlocked) 2.dp else 0.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (isUnlocked) sticker.emoji else "🔒",
                            fontSize = 40.sp
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = sticker.title,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isUnlocked) MaterialTheme.colorScheme.onSurface else Color(0xFF94A3B8)
                        )
                        Text(
                            text = sticker.description,
                            fontSize = 10.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                            lineHeight = 14.sp
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = if (isUnlocked) AmberLight else Color(0xFFE2E8F0)
                        ) {
                            Text(
                                text = sticker.criteria,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isUnlocked) Color(0xFFB45309) else Color(0xFF64748B),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
