package com.example.projeto02.view

import android.accessibilityservice.AccessibilityService.ScreenshotResult
import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projeto02.viewmodel.ContatoViewModel

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreen(
        contatoViewModel : ContatoViewModel = viewModel()

        ){
        val navController = rememberNavController()
        val uiState by contatoViewModel.mainScreenUiState.collectAsState()

        Scaffold(
            topBar = { TopAppBar() {
                Text(text = "Contatos")
            }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    contatoViewModel.navigate(navController)
                }) {
                   // Icon(painter = painterResource(id = uiState.fabIcon), contentDescription = null)

                }
            }
        ) {

            NavHost(navController = navController, startDestination = "contato_list"){
                composable("contato_list"){
                    contatoScreen(navController = navController, contatoViewModel = contatoViewModel)
                }
                composable("contato_detail"){
                    ScreenDetail(navController = navController, contatoViewModel = contatoViewModel)
                }
            }
        }

    }
