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
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ScreenDetail(
    navController: NavController,
    contatoViewModel: ContatoViewModel
) {
    val uiState by contatoViewModel.insertEditScreenUiState.collectAsState()

    Column(
    ) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp), elevation = 6.dp
        )
        {

            val inicial = uiState.nome[0].toString()
            Text(text = inicial, fontSize = 50.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

            }

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp), elevation = 0.dp
        )
        {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // val inicial = contato.nome[0].toString()
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = uiState.nome + " " + uiState.sobrenome, fontSize = 28.sp, textAlign = TextAlign.Center)
            }


        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Spacer(modifier = Modifier.height(26.dp))
            // val inicial = contato.nome[0].toString()
            Text(text = uiState.numero ,fontSize = 24.sp, textAlign = TextAlign.Center)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.height(26.dp))
            // val inicial = contato.nome[0].toString()
            Text(text = uiState.email ,fontSize = 24.sp, textAlign = TextAlign.Center)
        }
    }
}


