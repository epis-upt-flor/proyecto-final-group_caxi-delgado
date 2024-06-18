package com.xnical.combigo.presentation.screens.client.clinic.list.componets

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.presentation.components.ProgressBar
import com.xnical.combigo.presentation.screens.client.clinic.list.ClientClinicListViewModel

@Composable
fun GetClinics(paddingValues: PaddingValues, navController: NavHostController, vm: ClientClinicListViewModel = hiltViewModel()) {
    when(val response = vm.clinicsResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientClinicListContent(paddingValues, navController, clinics = response.data )
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