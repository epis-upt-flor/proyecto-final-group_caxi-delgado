package com.xnical.combigo.presentation.screens.client.patient.list.componets

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xnical.combigo.domain.model.Patient

@Composable
fun ClientPatientListContent(navController: NavHostController, paddingValues: PaddingValues, patients: List<Patient>) {

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(bottom = 55.dp)
            .fillMaxSize()
    ) {
        items(items = patients) { patient ->
            ClientPatientListItem(navController, patient)
        }
    }

}

