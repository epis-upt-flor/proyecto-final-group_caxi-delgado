package com.xnical.combigo.presentation.screens.admin.patient.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.xnical.combigo.presentation.screens.admin.patient.list.componets.AdminPatientListContent

@Composable
fun AdminPatientListScreen() {

    Scaffold() { paddingValues ->
        //GetCategories(paddingValues, navController)
        AdminPatientListContent(paddingValues = paddingValues)
    }

}