package com.example.projeto02.viewmodel

data class InsertEditScreenUiState(
    var nome:String="",
    var sobrenome : String = "",
    var numero:String="",
    var email : String = "",
    val isFavorito : Boolean = false
)
