package com.xnical.combigo.presentation.screens.client.patient.detail

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.screens.client.patient.detail.components.ClientPatientDetailContent

@Composable
fun ClientPatientDetailScreen(navController: NavHostController, patientParam: String) {

    Scaffold() { paddingValues ->
        ClientPatientDetailContent(paddingValues)
    }

}