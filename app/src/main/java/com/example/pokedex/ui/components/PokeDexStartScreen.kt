package com.example.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.R


@Composable
fun PokeDexStartScreen (modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.pokebola),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = stringResource(R.string.text_start),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
                lineHeight = 22.sp
            ),
            color = Color(0xFFAAAAAA), // Mudei para Gray pois o fundo agora é claro
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
    }


}