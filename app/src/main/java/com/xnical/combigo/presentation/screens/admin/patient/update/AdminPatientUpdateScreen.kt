package com.xnical.combigo.presentation.screens.admin.patient.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.components.DefaultTopBar
import com.xnical.combigo.presentation.screens.admin.patient.create.components.AdminPatientCreateContent
import com.xnical.combigo.presentation.screens.admin.patient.create.components.CreatePatient
import com.xnical.combigo.presentation.screens.admin.patient.update.components.AdminPatientUpdateContent
import com.xnical.combigo.presentation.screens.admin.patient.update.components.UpdatePatient
import com.xnical.combigo.presentation.ui.theme.Gray200

@Composable
fun AdminPatientUpdateScreen(navController: NavHostController, patientParam: String) {
    Log.d("AdminPatientUpdateScreen", "Clinic: ${patientParam}")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar paciente",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) {paddingValues ->
        AdminPatientUpdateContent(paddingValues = paddingValues)
    }
    UpdatePatient()
}