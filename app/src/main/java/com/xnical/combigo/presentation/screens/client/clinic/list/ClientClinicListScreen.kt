package com.xnical.combigo.presentation.screens.client.clinic.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.screens.client.clinic.list.componets.ClientClinicListContent

@Composable
fun ClientClinicListScreen() {

    Scaffold() {paddingValues ->
        //GetCategories(paddingValues, navController)
        ClientClinicListContent(paddingValues = paddingValues)
    }

}