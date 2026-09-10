package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LessonsScreen
import com.example.ui.screens.StoriesScreen
import com.example.ui.screens.WorksheetsScreen
import com.example.ui.theme.IndigoPrimary
import com.example.ui.theme.LinguaKidsTheme
import com.example.util.TtsManager

class MainActivity : ComponentActivity() {

    private lateinit var ttsManager: TtsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ttsManager = TtsManager(this)

        setContent {
            LinguaKidsTheme {
                LinguaKidsApp(ttsManager = ttsManager)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ttsManager.shutdown()
    }
}

@Composable
fun LinguaKidsApp(ttsManager: TtsManager) {
    val context = LocalContext.current
    val preferences = remember { UserPreferences(context) }

    var currentTab by remember { mutableIntStateOf(0) }
    var lessonInitialSubTab by remember { mutableIntStateOf(0) }
    var targetStoryId by remember { mutableStateOf<String?>(null) }

    DisposableEffect(Unit) {
        onDispose {
            ttsManager.stop()
        }
    }

    val navItems = listOf(
        Triple("Home", Icons.Default.Home, 0),
        Triple("Lessons", Icons.Default.MenuBook, 1),
        Triple("100 Stories", Icons.Default.AutoStories, 2),
        Triple("Worksheets", Icons.Default.Quiz, 3)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing,
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp
            ) {
                navItems.forEach { (title, icon, index) ->
                    val isSelected = currentTab == index
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            if (currentTab != index) {
                                ttsManager.stop()
                                currentTab = index
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = icon,
                                contentDescription = title,
                                tint = if (isSelected) IndigoPrimary else Color(0xFF64748B)
                            )
                        },
                        label = {
                            Text(
                                text = title,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) IndigoPrimary else Color(0xFF64748B)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = IndigoPrimary.copy(alpha = 0.12f)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Crossfade(
            targetState = currentTab,
            label = "tab_transition",
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { tab ->
            when (tab) {
                0 -> HomeScreen(
                    preferences = preferences,
                    ttsManager = ttsManager,
                    onNavigateToLessons = { subTab ->
                        lessonInitialSubTab = subTab
                        currentTab = 1
                    },
                    onNavigateToStories = { storyId ->
                        targetStoryId = storyId
                        currentTab = 2
                    },
                    onNavigateToWorksheets = {
                        currentTab = 3
                    }
                )
                1 -> LessonsScreen(
                    preferences = preferences,
                    ttsManager = ttsManager,
                    initialTab = lessonInitialSubTab
                )
                2 -> StoriesScreen(
                    preferences = preferences,
                    ttsManager = ttsManager,
                    initialStoryId = targetStoryId
                )
                3 -> WorksheetsScreen(
                    preferences = preferences,
                    ttsManager = ttsManager
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name! Welcome to LinguaKids", modifier = modifier)
}
