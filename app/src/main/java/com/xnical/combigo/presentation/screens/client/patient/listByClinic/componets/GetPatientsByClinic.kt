package com.xnical.combigo.presentation.screens.client.patient.listByClinic.componets

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.presentation.components.ProgressBar
import com.xnical.combigo.presentation.screens.client.patient.listByClinic.ClientPatientByClinicListViewModel

@Composable
fun GetPatientsByClinic(navController: NavHostController, paddingValues: PaddingValues, vm: ClientPatientByClinicListViewModel = hiltViewModel()) {
    when(val response = vm.patientsResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientPatientByClinicListContent(navController = navController, paddingValues = paddingValues , patients = response.data)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}