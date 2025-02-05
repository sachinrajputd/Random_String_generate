package com.example.randomstringgenerator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomstringgenerateapp.viewmodel.RandomStringViewModel

@Composable
fun RandomStringScreen(viewModel: RandomStringViewModel) {
    var inputLength by remember { mutableStateOf(10) }
    val randomStrings by viewModel.randomStrings.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = inputLength.toString(),
            onValueChange = { inputLength = it.toIntOrNull() ?: 10 },
            label = { Text("Max Length") }
        )
        Button(onClick = { viewModel.generateRandomString(inputLength) }) {
            Text("Generate Random String")
        }
        LazyColumn {
            itemsIndexed(randomStrings) { index, item ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("String: ${item.value}")
                        Text("Length: ${item.length}")
                        Text("Created: ${item.created}")
                        Button(onClick = { viewModel.deleteString(index) }) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
        Button(onClick = { viewModel.deleteAllStrings() }) {
            Text("Delete All")
        }
    }
}