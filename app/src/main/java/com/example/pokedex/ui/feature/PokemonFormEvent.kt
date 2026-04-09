package com.example.pokedex.ui.feature

sealed interface PokemonFormEvent {

    data class OnQueryChange(val name: String) : PokemonFormEvent

    data object OnSubmit : PokemonFormEvent
}