package com.example.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.VolumeUp
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.RewardSticker
import com.example.data.StickersData
import com.example.data.UserLevelInfo
import com.example.data.UserPreferences
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
import com.example.ui.theme.PurpleLight
import com.example.util.TtsManager

@Composable
fun HomeScreen(
    preferences: UserPreferences,
    ttsManager: TtsManager,
    onNavigateToLessons: (initialTab: Int) -> Unit,
    onNavigateToStories: (storyId: String?) -> Unit,
    onNavigateToWorksheets: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentGrade = preferences.currentGrade
    val currentLanguage = preferences.preferredLanguage
    val totalXp = preferences.totalXp
    val streakDays = preferences.streakDays
    val levelInfo: UserLevelInfo = StickersData.calculateLevel(totalXp)
    val unlockedStickers = preferences.getUnlockedStickers()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("home_screen_scroll"),
        contentPadding = PaddingValues(bottom = 96.dp)
    ) {
        // Top Header
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            listOf(IndigoPrimary.copy(alpha = 0.08f), Color.Transparent)
                        )
                    )
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "LinguaKids",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = IndigoPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = AmberSecondary.copy(alpha = 0.15f),
                                modifier = Modifier.padding(vertical = 4.dp)
                            ) {
                                Text(
                                    text = "CBSE Class 1–4",
                                    color = Color(0xFFB45309),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }
                        Text(
                            text = "Learn Hindi, Kannada & Malayalam with English guides",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f)
                        )
                    }

                    // Streak Badge
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFFFFFBEB),
                        shadowElevation = 2.dp
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(text = "🔥", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "$streakDays Day Streak",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Color(0xFFD97706)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // CBSE Class Selector
                Text(
                    text = "Select CBSE Standard:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    for (grade in 1..4) {
                        FilterChip(
                            selected = currentGrade == grade,
                            onClick = { preferences.currentGrade = grade },
                            label = {
                                Text(
                                    text = "Class $grade",
                                    fontWeight = if (currentGrade == grade) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 13.sp
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = IndigoPrimary,
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Language Mode Selector
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val langOptions = listOf(
                        Triple("both", "All Languages / എല്ലാം", Color(0xFF4338CA)),
                        Triple("hindi", "हिंदी Hindi", HindiSaffron),
                        Triple("kannada", "ಕನ್ನಡ Kannada", KannadaCrimson),
                        Triple("malayalam", "മലയാളം Malayalam", MalayalamEmerald)
                    )
                    items(langOptions) { (code, label, color) ->
                        val isSel = currentLanguage == code
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSel) color else color.copy(alpha = 0.08f),
                            modifier = Modifier
                                .clickable { preferences.preferredLanguage = code }
                        ) {
                            Box(
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = label,
                                    color = if (isSel) Color.White else color,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }

        // Hero Banner Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.img_linguakids_hero),
                        contentDescription = "LinguaKids Hero Art",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .background(
                                Brush.verticalGradient(
                                    listOf(Color.Transparent, Color(0xDD0F172A))
                                )
                            )
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "100 Trilingual Stories with Audio!",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Listen in Hindi, Kannada & English line-by-line",
                            color = Color(0xFFCBD5E1),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        // Level & XP Progress Card
        item {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface)
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
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(AmberLight),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "👑", fontSize = 22.sp)
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "Level ${levelInfo.levelNumber}: ${levelInfo.levelTitle}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "$totalXp XP earned in CBSE Class $currentGrade",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = IndigoLight
                        ) {
                            Text(
                                text = "+${levelInfo.maxXp - totalXp} to Lvl ${levelInfo.levelNumber + 1}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = IndigoPrimary,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    LinearProgressIndicator(
                        progress = { levelInfo.progress.coerceIn(0f, 1f) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        color = AmberSecondary,
                        trackColor = Color(0xFFF1F5F9)
                    )
                }
            }
        }

        // Section Title: Quick Practice
        item {
            Text(
                text = "Class $currentGrade Learning Paths",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }

        // 4 Learning Pathway Cards (2x2 Grid)
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Varnamala Card
                    LearningPathCard(
                        title = "Varnamala",
                        subtitle = "Alphabets & Sounds",
                        hindiScript = "वर्णमाला (Varnamala)",
                        kannadaScript = "ವರ್ಣಮಾಲೆ (Varnamaale)",
                        malayalamScript = "അക്ഷരമാല (Aksharamaala)",
                        icon = "🔤",
                        badgeColor = IndigoLight,
                        textColor = IndigoPrimary,
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigateToLessons(0) }
                    )

                    // Vocabulary Card
                    LearningPathCard(
                        title = "Vocabulary",
                        subtitle = "CBSE Words & Phrases",
                        hindiScript = "शब्दावली (Shabdavali)",
                        kannadaScript = "ಪದಕೋಶ (Padakosha)",
                        malayalamScript = "പദാവലി (Padhaavali)",
                        icon = "🍎",
                        badgeColor = HindiLight,
                        textColor = HindiSaffron,
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigateToLessons(1) }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Stories Card
                    LearningPathCard(
                        title = "300 Stories",
                        subtitle = "Values, Morals & Motivation",
                        hindiScript = "कहानियाँ (Kahaniyan)",
                        kannadaScript = "ಕಥೆಗಳು (Kathegalu)",
                        malayalamScript = "കഥകൾ (Kathakal)",
                        icon = "📚",
                        badgeColor = PurpleLight,
                        textColor = Color(0xFF7C3AED),
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigateToStories(null) }
                    )

                    // Worksheets Card
                    LearningPathCard(
                        title = "Worksheets",
                        subtitle = "Quizzes & Stickers",
                        hindiScript = "अभ्यास (Abhyaas)",
                        kannadaScript = "ಅಭ್ಯಾಸ (Abhyaasa)",
                        malayalamScript = "പരിശീലനം (Parisheelanam)",
                        icon = "📝",
                        badgeColor = GreenLight,
                        textColor = Color(0xFF15803D),
                        modifier = Modifier.weight(1f),
                        onClick = onNavigateToWorksheets
                    )
                }
            }
        }

        // Featured Daily Story Preview
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 6.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = AmberLight.copy(alpha = 0.6f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFF59E0B)
                        ) {
                            Text(
                                text = "⭐ Story of the Day (10 mins)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                ttsManager.speak(
                                    "प्यासा कौआ। एक बहुत गर्म दोपहर थी। एक प्यासा कौआ पानी की तलाश में उड़ रहा था।",
                                    "hi"
                                )
                            },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.VolumeUp,
                                contentDescription = "Listen to preview",
                                tint = Color(0xFFB45309)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "The Thirsty Crow",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF78350F)
                    )
                    Text(
                        text = "प्यासा कौआ (Pyaasa Kauwa) • ಬಾಯಾರಿದ ಕಾಗೆ (Baayarida Kaage) • ദാഹിച്ച കാക്ക (Daahicha Kaakka)",
                        fontSize = 12.sp,
                        color = Color(0xFF92400E)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "A thirsty crow uses his clever mind to drop pebbles into a pitcher. Discover wisdom, speaking audio, and English line-by-line translation.",
                        fontSize = 12.sp,
                        color = Color(0xFF78350F).copy(alpha = 0.85f),
                        lineHeight = 17.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFFD97706),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onNavigateToStories("story_1") }
                    ) {
                        Box(
                            modifier = Modifier.padding(vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Read & Listen Story (Multi-Language) →",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }
        }

        // Sticker Album Showcase
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Reward Stickers (${unlockedStickers.size}/${StickersData.allStickers.size})",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "View All →",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = IndigoPrimary,
                    modifier = Modifier.clickable { onNavigateToWorksheets() }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(StickersData.allStickers) { sticker: RewardSticker ->
                    val isUnlocked = unlockedStickers.contains(sticker.id)
                    StickerItemMini(sticker = sticker, isUnlocked = isUnlocked)
                }
            }
        }
    }
}

@Composable
fun LearningPathCard(
    title: String,
    subtitle: String,
    hindiScript: String,
    kannadaScript: String,
    malayalamScript: String = "",
    icon: String,
    badgeColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(badgeColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = icon, fontSize = 20.sp)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = hindiScript,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = HindiSaffron
            )
            Text(
                text = kannadaScript,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = KannadaCrimson
            )
            if (malayalamScript.isNotEmpty()) {
                Text(
                    text = malayalamScript,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = MalayalamEmerald
                )
            }
        }
    }
}

@Composable
fun StickerItemMini(
    sticker: RewardSticker,
    isUnlocked: Boolean
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = if (isUnlocked) AmberLight.copy(alpha = 0.5f) else Color(0xFFF1F5F9),
        shadowElevation = if (isUnlocked) 2.dp else 0.dp,
        modifier = Modifier.width(90.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (isUnlocked) sticker.emoji else "🔒",
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = sticker.title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = if (isUnlocked) Color(0xFF92400E) else Color(0xFF94A3B8),
                maxLines = 1
            )
        }
    }
}
