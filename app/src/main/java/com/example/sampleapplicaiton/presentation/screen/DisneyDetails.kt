package com.example.sampleapplicaiton.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.sampleapplicaiton.R
import com.example.sampleapplicaiton.domain.model.DisneyData
import com.example.sampleapplicaiton.presentation.Screen
import com.example.sampleapplicaiton.presentation.UiState
import com.example.sampleapplicaiton.presentation.viewmodel.DisneyViewModel

@Composable
fun HomeScreen(viewModel: DisneyViewModel = hiltViewModel(), onClick: (String) -> Unit) {
    val uiState by viewModel.uiState

    LaunchedEffect(Unit) { viewModel.fetchData() }

    when (uiState) {
        is UiState.Loading -> Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) { CircularProgressIndicator() }

        is UiState.Success -> LazyColumn {
            items((uiState as UiState.Success<List<DisneyData>>).data) { character ->
                CharacterItem(
                    character = character,
                    onItemClick = { selectedItem -> onClick(selectedItem) })
            }
        }

        is UiState.Error -> Text("Error: ${(uiState as UiState.Error).message}")
    }
}

@Composable
fun CharacterItem(character: DisneyData, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onItemClick(character.name) },
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
