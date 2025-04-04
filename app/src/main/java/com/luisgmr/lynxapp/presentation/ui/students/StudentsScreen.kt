package com.luisgmr.lynxapp.presentation.ui.students

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentsScreen(navController: NavController) {
    Button(
        onClick = { navController.popBackStack() }
    ) { Text("Voltar") }
    Text("Tela de estudantes")
}