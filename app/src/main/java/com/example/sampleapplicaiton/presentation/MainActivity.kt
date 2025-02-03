package com.example.sampleapplicaiton.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.sampleapplicaiton.presentation.screen.Navigation
import com.example.sampleapplicaiton.presentation.viewmodel.DisneyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: DisneyViewModel by viewModels()
           Navigation()
        }
    }
}
