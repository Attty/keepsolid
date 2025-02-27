package com.example.kipsolid.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


// Світла тема
val LightGreenColorScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryVariantLight,
    onPrimaryContainer = Color(0xFF0A3000),
    secondary = secondaryLight,
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFDCEABF),
    onSecondaryContainer = Color(0xFF131F00),
    tertiary = accentLight,
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFA7F3DF),
    onTertiaryContainer = Color(0xFF002019),
    error = errorLight,
    background = backgroundLight,
    onBackground = onSurfaceLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = Color(0xFFDDE5D9),
    onSurfaceVariant = Color(0xFF424940),
    outline = Color(0xFF72796F)
)

// Темна тема
val DarkGreenColorScheme = darkColorScheme(
    primary = Color(0xFF7DCF80),
    onPrimary = Color(0xFF00390D),
    primaryContainer = Color(0xFF005317),
    onPrimaryContainer = Color(0xFF97F999),
    secondary = Color(0xFFC0CD97),
    onSecondary = Color(0xFF2A3600),
    secondaryContainer = Color(0xFF404B14),
    onSecondaryContainer = Color(0xFFDCEABF),
    tertiary = Color(0xFF8AD6C3),
    onTertiary = Color(0xFF00382D),
    tertiaryContainer = Color(0xFF005141),
    onTertiaryContainer = Color(0xFFA7F3DF),
    error = Color(0xFFE5736D),
    background = Color(0xFF1A1C19),
    onBackground = Color(0xFFE2E3DC),
    surface = Color(0xFF121410),
    onSurface = Color(0xFFC6C7C0),
    surfaceVariant = Color(0xFF424940),
    onSurfaceVariant = Color(0xFFC1C9BD),
    outline = Color(0xFF8B9389)
)


@Composable
fun KipsolidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkGreenColorScheme
        else -> LightGreenColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}