package com.example.pokedex.ui.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.ui.components.PokeDexStartScreen
import com.example.pokedex.ui.components.PokeDexSuccess
import com.example.pokedex.ui.components.PokeDexTextField
import com.example.pokedex.ui.components.PokemonLoading
import com.example.pokedex.ui.components.PokemonNotFound
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonRoute(
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = viewModel()
) {
    val formState = viewModel.formState

    PokemonScreen(
        formState = formState,
        onFormEvent = viewModel::onFormEvent
    )
}

@Composable
fun PokemonScreen(
    formState: PokemonFormState,
    onFormEvent: (PokemonFormEvent) -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PokeDexTextField(
            value = formState.name,
            onValueChange = {
                onFormEvent(PokemonFormEvent.OnQueryChange(it))
            },
            onSearchClick = {
                onFormEvent(PokemonFormEvent.OnSubmit)
            }
        )

        when {
            formState.isLoading -> {
                PokemonLoading()
            }
            formState.isInitial -> {
                PokeDexStartScreen()
            }
            formState.isError -> {
                PokemonNotFound(pokemon = formState.name)
            }
            else -> {
                PokeDexSuccess(
                    name = formState.name,
                    number = formState.number.toString(),
                    imageRes = formState.imageRes,
                    type = formState.type,
                    height = formState.height,
                    weight = formState.weight,
                    baseExperience = formState.baseExperience.toString(),
                    hp = formState.hp,
                    attack = formState.attack,
                    defense = formState.defense,
                    specialAttack = formState.specialAttack,
                    specialDefense = formState.specialDefense,
                    speed = formState.speed,
                    backgroundColor = formState.backgroundColor,
                    abilities = formState.abilities
                )
            }
        }
    }
}

@Preview
@Composable
private fun PokemonScreenPreview() {
    PokedexTheme(dynamicColor = false) {
        PokemonScreen(
            formState = PokemonFormState()
        )
    }
}