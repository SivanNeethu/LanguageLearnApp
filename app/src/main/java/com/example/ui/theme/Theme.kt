package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
  primary = IndigoLight,
  onPrimary = IndigoPrimaryVariant,
  primaryContainer = IndigoPrimary,
  onPrimaryContainer = IndigoLight,
  secondary = AmberSecondary,
  onSecondary = DarkBackground,
  secondaryContainer = AmberDark,
  onSecondaryContainer = AmberLight,
  tertiary = TealLight,
  background = DarkBackground,
  surface = DarkSurface,
  onBackground = DarkTextPrimary,
  onSurface = DarkTextPrimary,
  outline = BorderSubtle
)

private val LightColorScheme = lightColorScheme(
  primary = IndigoPrimary,
  onPrimary = SurfaceLight,
  primaryContainer = IndigoLight,
  onPrimaryContainer = IndigoPrimaryVariant,
  secondary = AmberDark,
  onSecondary = SurfaceLight,
  secondaryContainer = AmberLight,
  onSecondaryContainer = AmberDark,
  tertiary = TealTertiary,
  background = BackgroundLight,
  surface = SurfaceLight,
  onBackground = TextPrimary,
  onSurface = TextPrimary,
  outline = BorderSubtle
)

@Composable
fun LinguaKidsTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  MyApplicationTheme(darkTheme = darkTheme, dynamicColor = dynamicColor, content = content)
}

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}

