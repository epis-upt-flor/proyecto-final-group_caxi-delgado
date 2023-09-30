package com.xnical.combigo.presentation.screens.client.patient.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.screens.client.patient.list.componets.ClientPatientListContent

@Composable
fun ClientPatientListScreen() {

    Scaffold() { paddingValues ->
        //GetCategories(paddingValues, navController)
        ClientPatientListContent(paddingValues = paddingValues)
    }

}