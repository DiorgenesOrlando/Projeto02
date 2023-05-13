package com.example.projeto02.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.tasklistapp.viewmodel.ContatoScreenUiState
import com.example.tasklistapp.viewmodel.MainScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContatoViewModel : ViewModel() {
    private var _mainScreenUiState : MutableStateFlow<MainScreenUiState> = MutableStateFlow(
        MainScreenUiState()
    )
    val mainScreenUiState: StateFlow<MainScreenUiState> = _mainScreenUiState.asStateFlow()

    private var _contatoScreenUiState : MutableStateFlow<ContatoScreenUiState> = MutableStateFlow(ContatoScreenUiState())
    val contatoScreenUiState : StateFlow<ContatoScreenUiState> = _contatoScreenUiState.asStateFlow()

    private var _insertEditScreenUiState : MutableStateFlow<InsertEditScreenUiState> = MutableStateFlow(InsertEditScreenUiState())
    val insertEditScreenUiState : StateFlow<InsertEditScreenUiState> = _insertEditScreenUiState.asStateFlow()

    fun onTaskIsImportantChange(newContatoFavorito: Boolean){
        _insertEditScreenUiState.update { currentState ->
            currentState.copy(isFavorito = newContatoFavorito)
        }

    }


    fun navigate(navController: NavController) {
    }
    }