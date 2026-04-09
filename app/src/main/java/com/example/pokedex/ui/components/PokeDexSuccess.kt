package com.example.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.R
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun PokeDexSuccess(
    name: String = "",
    number: String = "",
    imageRes: Int = R.drawable.pokebola,
    type: String = "",
    height: String = "",
    weight: String = "",
    baseExperience: String = "",
    hp: Int = 0,
    attack: Int = 0,
    defense: Int = 0,
    specialAttack: Int = 0,
    specialDefense: Int = 0,
    speed: Int = 0,
    backgroundColor: Color = Color.Transparent,
    abilities: List<String> = emptyList(),
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(8.dp))
        PokemonHeaderCard(
            name = name,
            number = number,
            imageRes = imageRes,
            type = type,
            backgroundColor = backgroundColor
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically
            ) {
                InfoItem(height, "Altura", Modifier.weight(1f))

                VerticalDivider(modifier = Modifier.fillMaxHeight())

                InfoItem(weight, "Peso", Modifier.weight(1f))

                VerticalDivider(modifier = Modifier.fillMaxHeight())

                InfoItem(baseExperience, "Exp. base", Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Base stats",
                    fontWeight = FontWeight.Bold
                )
                InfoStats("Hp", hp)
                InfoStats("Ataque", attack)
                InfoStats("Defesa", defense)
                InfoStats("Sp.Atk", specialAttack)
                InfoStats("Sp.Def", specialDefense)
                InfoStats("Velocidade", speed)
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Habilidades",
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    abilities.forEach { ability ->
                        AbilitiesCard(ability = ability)
                    }
                }
            }
        }
    }
}

@Composable
fun InfoItem(
    valor: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = valor,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFAAAAAA)
        )
    }
}


@Composable
fun InfoStats(
    state: String,
    valor: Int,
    modifier: Modifier = Modifier
) {
    val progress = (valor / 255f).coerceIn(0f, 1f)

    val barColor = when {
        valor >= 150 -> Color(0xFF4CAF50)
        valor >= 90  -> Color(0xFFFFB830)
        else              -> Color.Yellow
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = state,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFAAAAAA)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = valor.toString(),
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(8.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFE0E0E0))
                .border(
                    width = 1.dp,
                    color = Color(0xFFAAAAAA),
                    shape = RoundedCornerShape(50),
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progress)
                    .clip(RoundedCornerShape(50))
                    .background(barColor)
            )
        }
    }
}

@Composable
fun AbilitiesCard(
    ability: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(50),
        color = Color(0xFFFFF1D6)
    ) {
        Text(
            text = ability,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
            color = Color(0xFFE29A1F),
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp
        )
    }
}

@Composable
fun PokemonHeaderCard(
    name: String,
    number: String,
    imageRes: Int,
    type: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = number,
                color = Color.White.copy(alpha = 0.7f),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = RoundedCornerShape(50),
                color = Color.White.copy(alpha = 0.3f)
            ) {
                Text(
                    text = type,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun PokeDexSuccessPreview() {
    PokedexTheme() {
        PokeDexSuccess()
    }
}