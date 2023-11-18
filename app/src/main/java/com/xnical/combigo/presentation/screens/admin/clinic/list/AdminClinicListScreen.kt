package com.xnical.combigo.presentation.screens.admin.clinic.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.xnical.combigo.presentation.screens.admin.clinic.list.componets.AdminClinicListContent

@Composable
fun AdminClinicListScreen() {

    Scaffold() {paddingValues ->
        //GetCategories(paddingValues, navController)
        AdminClinicListContent(paddingValues = paddingValues)
    }

}