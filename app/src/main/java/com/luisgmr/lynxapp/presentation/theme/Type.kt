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
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily()),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily()),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily()),
        titleSmall = titleSmall.copy(fontFamily = fontFamily()),
        titleMedium = titleMedium.copy(fontFamily = fontFamily()),
        titleLarge = titleLarge.copy(fontFamily = fontFamily()),
        bodySmall = bodySmall.copy(fontFamily = fontFamily()),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily()),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily()),
        labelSmall = labelSmall.copy(fontFamily = fontFamily()),
        labelMedium = labelMedium.copy(fontFamily = fontFamily()),
        labelLarge = labelLarge.copy(fontFamily = fontFamily())
    )
}

