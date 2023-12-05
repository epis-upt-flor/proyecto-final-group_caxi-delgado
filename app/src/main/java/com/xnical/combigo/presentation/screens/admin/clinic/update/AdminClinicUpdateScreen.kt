package com.xnical.combigo.presentation.screens.admin.clinic.update

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.components.DefaultTopBar
import com.xnical.combigo.presentation.screens.admin.clinic.update.components.AdminClinicUpdateContent
import com.xnical.combigo.presentation.screens.admin.clinic.update.components.UpdateClinic
import com.xnical.combigo.presentation.ui.theme.Gray200

@Composable
fun AdminClinicUpdateScreen(navController: NavHostController, clinicParam: String) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva Clinica",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) { paddingValues ->
        AdminClinicUpdateContent(paddingValues = paddingValues)
    }
    UpdateClinic()
}