package com.example.tasklistapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.projeto02.viewmodel.ContatoViewModel

@Composable
fun InsertEditTaskSccreen(
    navController: NavController,
    comtatoViewModel: ContatoViewModel
){
    val uiState by comtatoViewModel.insertEditScreenUiState.collectAsState()
    InsertEditForm(
        name = uiState.nome,
        important = uiState.isFavorito
    )
    // onNameChange = {comtatoViewModel.onTaskNameChange(it)},
    { comtatoViewModel.onTaskIsImportantChange(it) }
}

@Composable
fun  InsertEditForm(
    name: String,
    important: Boolean,
    onImportantChange: (Boolean) -> Unit
){
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center){
        Column(horizontalAlignment = Alignment.Start) {

        OutlinedTextField(label = { Text(text = "Task Name")},
            value = name , onValueChange = {}
        )
        Row() {
            Checkbox(checked = important, onCheckedChange = onImportantChange)
            Text(text = "Important Task")
        }
    }}
    
}