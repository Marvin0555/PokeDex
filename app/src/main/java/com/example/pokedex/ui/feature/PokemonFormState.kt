package com.example.pokedex.ui.feature

import androidx.compose.ui.graphics.Color
import com.example.pokedex.R

data class PokemonFormState (
    val name: String = "",
    val number: Int = 0,
    val type: String = "",
    val imageRes: Int = R.drawable.pokebola,
    val height: String = "",
    val weight: String = "",
    val baseExperience: Int = 0,
    val abilities: List<String> = emptyList(),
    val backgroundColor: Color = Color.Transparent,
    val hp: Int = 0,
    val attack: Int = 0,
    val defense: Int = 0,
    val specialAttack: Int = 0,
    val specialDefense: Int = 0,
    val speed: Int = 0,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isInitial: Boolean = true
)