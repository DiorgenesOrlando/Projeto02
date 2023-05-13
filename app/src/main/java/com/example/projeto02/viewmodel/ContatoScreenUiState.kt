package com.example.tasklistapp.viewmodel

import com.example.projeto02.model.Contato


data class ContatoScreenUiState(
  val allContacts : List<Contato> =  listOf(
    Contato("Maria", "Rosa", "99125003", "email@example.com", false)


)
)
