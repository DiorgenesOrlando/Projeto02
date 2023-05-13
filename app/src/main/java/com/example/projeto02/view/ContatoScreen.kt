package com.example.projeto02.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projeto02.R
import com.example.projeto02.model.Contato
import com.example.projeto02.viewmodel.ContatoViewModel
//import com.example.tasklistapp.R
//import com.example.tasklistapp.model.Task
import android.graphics.Typeface
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.font.FontWeight
import com.example.projeto02.viewmodel.InsertEditScreenUiState
import com.example.tasklistapp.viewmodel.ContatoScreenUiState

@Composable
fun contatoScreen(
    navController: NavController,
    contatoViewModel: ContatoViewModel
){
    val uiState by contatoViewModel.contatoScreenUiState.collectAsState()
    val contatoState by contatoViewModel.insertEditScreenUiState.collectAsState();
    contatoList( uiState.allContacts, navController,uiState, contatoState) {contato, isFavorited ->
        contatoViewModel.onTaskIsImportantChange(isFavorited)
    }

}
@Composable
fun contatoList(contatos : List<Contato>, navController: NavController, uiState : ContatoScreenUiState, contatoState : InsertEditScreenUiState,
                onFavoritedChange: (Contato, Boolean) -> Unit){
    LazyColumn(){
        items(contatos){contato->
            contatoEntry(contato = contato, navController,uiState,contatoState){isCompleted ->
                onFavoritedChange(contato, isCompleted)
            }

        }


    }

}
@Composable
fun contatoEntry(
    contato : Contato,navController: NavController,uiState : ContatoScreenUiState,contatoState : InsertEditScreenUiState,
    onFavoritedChange:( Boolean) -> Unit
){


    Card(     modifier = Modifier.clickable(onClick = {
        contatoState.nome = contato.nome
        contatoState.sobrenome = contato.sobrenome
        contatoState.numero = contato.numero
        contatoState.email = contato.email




        navController.navigate("contato_detail")
    })
    ) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp), elevation = 6.dp)
    {
        Row(modifier = Modifier.fillMaxWidth( ), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

                Row(
                    modifier = Modifier.widthIn(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (contato.isFavorito) {
                        //Icon(painter = painterResource(R.drawable.baseline_priority_high_24), contentDescription = "high priority")
                    }

                    Row(
                        modifier = Modifier.widthIn(20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val inicial = contato.nome[0].toString()
                        Text(text = inicial, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    }
                    Row(
                        modifier = Modifier.widthIn(30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // val inicial = contato.nome[0].toString()
                        Text(text = contato.nome + " " + contato.sobrenome, fontSize = 20.sp)
                    }
                }
                Row(
                    modifier = Modifier.widthIn(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = contato.isFavorito, onCheckedChange = {})
                }
            }

        }

    }}