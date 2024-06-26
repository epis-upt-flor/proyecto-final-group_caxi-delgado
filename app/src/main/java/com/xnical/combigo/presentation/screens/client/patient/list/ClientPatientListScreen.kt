package com.xnical.combigo.presentation.screens.client.patient.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.components.DefaultSearchView
import com.xnical.combigo.presentation.screens.client.clinic.list.componets.GetClinics
import com.xnical.combigo.presentation.screens.client.patient.list.componets.ClientPatientListContent
import com.xnical.combigo.presentation.screens.client.patient.list.componets.GetPatients

@Composable
fun ClientPatientListScreen(navController: NavHostController, vm: ClientPatientListViewModel = hiltViewModel()) {

    vm.getPatients()
    Scaffold(
        topBar = {
            DefaultSearchView(
                value = vm.search,
                onValueChange = { text ->
                    vm.onSearchInput(text)
                },
                navController = navController,
                onClick = {
                    if (vm.search.isNotBlank()){
                        vm.getPatientsByName(vm.search)
                    }
                }
            )
        }
    ) { paddingValues ->
        GetPatients(navController = navController, paddingValues = paddingValues)
        //ClientPatientListContent(paddingValues = paddingValues)
    }

}