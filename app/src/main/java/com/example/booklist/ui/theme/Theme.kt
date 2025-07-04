package com.example.booklist.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF80D99A),
    onPrimary = Color(0xFF00391B),
    primaryContainer = Color(0xFF00522A),
    onPrimaryContainer = Color(0xFF9BF6B4),
    secondary = Color(0xFFB5CCB9),
    onSecondary = Color(0xFF223527),
    secondaryContainer = Color(0xFF384B3C),
    onSecondaryContainer = Color(0xFFD1E8D4),
    tertiary = Color(0xFFA2CEDB),
    onTertiary = Color(0xFF033540),
    tertiaryContainer = Color(0xFF204C58),
    onTertiaryContainer = Color(0xFFBEEAF7),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF191C19),
    onBackground = Color(0xFFE1E3DE),
    surface = Color(0xFF191C19),
    onSurface = Color(0xFFE1E3DE),
    surfaceVariant = Color(0xFF414941),
    onSurfaceVariant = Color(0xFFC1C9BF),
    outline = Color(0xFF8B938A),
    inverseOnSurface = Color(0xFF191C19),
    inverseSurface = Color(0xFFE1E3DE),
    inversePrimary = Color(0xFF006D3B),
    surfaceTint = Color(0xFF80D99A),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006D3B),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF9BF6B4),
    onPrimaryContainer = Color(0xFF00210D),
    secondary = Color(0xFF4F6353),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFD1E8D4),
    onSecondaryContainer = Color(0xFF0D1F13),
    tertiary = Color(0xFF3A646F),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFBEEAF7),
    onTertiaryContainer = Color(0xFF001F26),
    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    background = Color(0xFFFBFDF7),
    onBackground = Color(0xFF191C19),
    surface = Color(0xFFFBFDF7),
    onSurface = Color(0xFF191C19),
    surfaceVariant = Color(0xFFDDE5DB),
    onSurfaceVariant = Color(0xFF414941),
    outline = Color(0xFF717971),
    inverseOnSurface = Color(0xFFF0F1EC),
    inverseSurface = Color(0xFF2E312E),
    inversePrimary = Color(0xFF80D99A),
    surfaceTint = Color(0xFF006D3B),
)

@Composable
fun BookListTheme(
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

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}