package com.example.pokedex.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    // "Pokédex" na TopBar
    titleLarge = TextStyle(
        // fontFamily = Poppins,       // ← descomente se quiser fonte custom
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),

    // "Busque seu Pokémon" na TopBar
    titleSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
    ),

    // Placeholder do TextField
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),

    // Texto "Digite o nome..." abaixo da pokébola
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    ),
)