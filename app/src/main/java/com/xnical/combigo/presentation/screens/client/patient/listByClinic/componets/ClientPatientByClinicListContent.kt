package com.xnical.combigo.presentation.screens.client.patient.listByClinic.componets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.xnical.combigo.domain.model.Patient

@Composable
fun ClientPatientByClinicListContent(navController: NavHostController, paddingValues: PaddingValues, patients: List<Patient>) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        items(items = patients) { patient ->
            ClientPatientByClinicListItem(navController, patient)
        }
    }
}

