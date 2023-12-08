package com.xnical.combigo.presentation.screens.admin.patient.create

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.components.DefaultTopBar
import com.xnical.combigo.presentation.screens.admin.patient.create.components.AdminPatientCreateContent
import com.xnical.combigo.presentation.ui.theme.Gray200

@Composable
fun AdminPatientCreateScreen(navController: NavHostController, clinicParam: String) {
    Log.d("AdminPatientCreteScreen", "Clinic: ${clinicParam}")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo paciente",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) {paddingValues ->
        AdminPatientCreateContent(paddingValues = paddingValues)
    }
}