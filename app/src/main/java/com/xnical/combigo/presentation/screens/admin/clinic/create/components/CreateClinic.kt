package com.xnical.combigo.presentation.screens.admin.clinic.create.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.presentation.components.ProgressBar
import com.xnical.combigo.presentation.screens.admin.clinic.create.AdminClinicCreateViewModel

@Composable
fun CreateClinic(vm: AdminClinicCreateViewModel = hiltViewModel()) {

    when(val response = vm.clinicResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
            vm.clearForm()
            Toast.makeText(LocalContext.current, "Los datos se han actualizado correctamete", Toast.LENGTH_LONG).show()
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