package com.example.pokedex.ui.feature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokemonViewModel() : ViewModel() {
    var formState by mutableStateOf(PokemonFormState())
        private set

    fun onFormEvent(event: PokemonFormEvent) {
        when(event){
            is PokemonFormEvent.OnQueryChange -> {
                formState = formState.copy(
                    name = event.name
                )
            } is PokemonFormEvent.OnSubmit -> {
                doSearch()
            }
        }
    }

    private fun doSearch() {
        viewModelScope.launch {
            formState = formState.copy(
                isLoading = true,
                isInitial = false,
                isError = false
            )
            
            delay(3000) // Simula o tempo de rede

            // Simulação de lógica: se o nome for vazio ou "erro", dá erro
            if (formState.name.isBlank() || formState.name.lowercase() == "erro") {
                formState = formState.copy(
                    isLoading = false,
                    isError = true
                )
            } else {
                formState = formState.copy(
                    isLoading = false,
                    isError = false
                    // Aqui você preencheria os dados do Pokemon real futuramente
                )
            }
        }
    }
}