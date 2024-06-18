package com.xnical.combigo.presentation.screens.admin.patient.list.componets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.presentation.screens.admin.patient.list.AdminPatientListViewModel

@Composable
fun AdminPatientListContent(navController: NavHostController, paddingValues: PaddingValues, patients: List<Patient>) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        items(items = patients) { patient ->
            AdminPatientListItem(navController, patient)
        }
    }
}

