package com.example.pokedex.ui.components

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonLoading() {
    val infiniteTransition = rememberInfiniteTransition(label = "dots")

    val alpha1 by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.2f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1200
                0.2f at 0
                1f at 300
                0.2f at 600
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "alpha1"
    )

    val alpha2 by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.2f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1200
                0.2f at 200
                1f at 500
                0.2f at 800
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "alpha2"
    )

    val alpha3 by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.2f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1200
                0.2f at 400
                1f at 700
                0.2f at 1000
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "alpha3"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf(alpha1, alpha2, alpha3).forEach { alpha ->
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .graphicsLayer { this.alpha = alpha }
                        .background(
                            color = Color(0xFFCC0000),
                            shape = CircleShape
                        )
                )
            }
        }

        Text(
            text = "Buscando na PokéAPI...",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFAAAAAA)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun PokemonLoadingPreview() {
    PokedexTheme {
        PokemonLoading()
    }
}
