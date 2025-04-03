package com.luisgmr.lynxapp.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.luisgmr.lynxapp.R

fun fontFamily() = FontFamily(
    Font(R.font.rethink_sans_regular, weight = FontWeight.Normal),
    Font(R.font.rethink_sans_medium, weight = FontWeight.Medium),
    Font(R.font.rethink_sans_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.rethink_sans_bold, weight = FontWeight.Bold),
    Font(R.font.rethink_sans_extra_bold, weight = FontWeight.ExtraBold),
)

val Typography = Typography().run {
    copy(
        displaySmall = displaySmall.copy(fontFamily = fontFamily()),
        displayMedium = displayMedium.copy(fontFamily = fontFamily()),
        displayLarge = displayLarge.copy(fontFamily = fontFamily()),
        headlineSmall = displayLarge.copy(fontFamily = fontFamily()),
        headlineMedium = displayLarge.copy(fontFamily = fontFamily()),
        headlineLarge = displayLarge.copy(fontFamily = fontFamily()),
        titleSmall = displayLarge.copy(fontFamily = fontFamily()),
        titleMedium = displayLarge.copy(fontFamily = fontFamily()),
        titleLarge = displayLarge.copy(fontFamily = fontFamily()),
        bodySmall = displayLarge.copy(fontFamily = fontFamily()),
        bodyMedium = displayLarge.copy(fontFamily = fontFamily()),
        bodyLarge = displayLarge.copy(fontFamily = fontFamily()),
        labelSmall = displayLarge.copy(fontFamily = fontFamily()),
        labelMedium = displayLarge.copy(fontFamily = fontFamily()),
        labelLarge = displayLarge.copy(fontFamily = fontFamily())
    )
}

