package com.example.randomstringgenerateapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.randomstringgenerateapp.repository.RandomStringRepository
import com.example.randomstringgenerateapp.ui.theme.RandomStringGenerateAppTheme
import com.example.randomstringgenerateapp.viewmodel.RandomStringViewModel
import com.example.randomstringgenerator.ui.RandomStringScreen
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: RandomStringViewModel = hiltViewModel()
            RandomStringScreen(viewModel)
        }
    }
}
