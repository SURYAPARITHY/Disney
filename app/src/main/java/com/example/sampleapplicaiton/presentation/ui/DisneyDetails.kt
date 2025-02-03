package com.example.sampleapplicaiton.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.sampleapplicaiton.R
import com.example.sampleapplicaiton.domain.model.DisneyData
import com.example.sampleapplicaiton.presentation.viewmodel.DisneyViewModel

@Composable
fun CharacterList(viewModel: DisneyViewModel) {
    LazyColumn {
        items(viewModel.disneyDataDetails.value) { character ->
            CharacterItem(character)
        }
    }
}

@Composable
fun CharacterItem(character: DisneyData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.size(100.dp),
            model = character.imageUrl,
            contentDescription = null,
            placeholder = painterResource(R.drawable.placeholder)
        )
        Text(
            text = character.name,
            modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
            textAlign = TextAlign.Center
        )
    }
}
