package com.xnical.combigo.presentation.screens.admin.clinic.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.components.DefaultTopBar
import com.xnical.combigo.presentation.screens.admin.clinic.create.components.AdminClinicCreateContent
import com.xnical.combigo.presentation.screens.admin.clinic.create.components.CreateClinic
import com.xnical.combigo.presentation.ui.theme.Gray200

@Composable
fun AdminClinicCreateScreen(navController: NavHostController) {

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
        AdminClinicCreateContent(paddingValues = paddingValues)
    }
    CreateClinic()
}