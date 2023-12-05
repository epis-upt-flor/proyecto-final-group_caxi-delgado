package com.xnical.combigo.presentation.screens.client.clinic.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.screens.client.clinic.list.componets.ClientClinicListContent
import com.xnical.combigo.presentation.screens.client.clinic.list.componets.GetClinics

@Composable
fun ClientClinicListScreen(navController: NavHostController) {

    Scaffold() {paddingValues ->
        GetClinics(paddingValues, navController)
    }

}