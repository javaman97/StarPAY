package com.brian.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.brian.myapplication.R

// Set of Material typography styles to start with
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Afacad Flux")

val fontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider),
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,

    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val afacadfluxFontFamily = FontFamily(
    androidx.compose.ui.text.font.Font(R.font.afacadflux_black, FontWeight.Black),
    androidx.compose.ui.text.font.Font(R.font.afacadflux_bold, FontWeight.Bold),
    androidx.compose.ui.text.font.Font(R.font.afacadflux_thin, FontWeight.Thin),
    androidx.compose.ui.text.font.Font(R.font.afacadflux_light, FontWeight.Light),
    androidx.compose.ui.text.font.Font(R.font.afacadflux_medium, FontWeight.Medium),
    androidx.compose.ui.text.font.Font(R.font.afacadflux_semibold, FontWeight.SemiBold),
    androidx.compose.ui.text.font.Font(R.font.afacadflux_extrabold, FontWeight.ExtraBold),
    androidx.compose.ui.text.font.Font(R.font.afacadflux_extralight, FontWeight.ExtraLight),
    androidx.compose.ui.text.font.Font(R.font.afacadflux_regular, FontWeight.Normal),
)
