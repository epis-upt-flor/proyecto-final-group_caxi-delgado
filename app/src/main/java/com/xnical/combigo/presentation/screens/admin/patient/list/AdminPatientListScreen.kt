package com.xnical.combigo.presentation.screens.admin.patient.list

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.presentation.components.DefaultTopBar
import com.xnical.combigo.presentation.navigation.screen.admin.AdminClinicScreen
import com.xnical.combigo.presentation.screens.admin.patient.list.componets.AdminPatientListContent
import com.xnical.combigo.presentation.screens.admin.patient.list.componets.DeletePatients
import com.xnical.combigo.presentation.screens.admin.patient.list.componets.GetPatients

@Composable
fun AdminPatientListScreen(navController: NavHostController, clinicParam: String) {
    Log.d("AdminPatientListScreen", "Clinic: ${clinicParam}")
    val clinicParse = Clinic.fromJson(clinicParam).toJson()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Pacientes",
                navController = navController,
                upAvailable = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {
                    navController.navigate(route = AdminClinicScreen.PatientCreate.passClinic(clinicParse))
                },
                backgroundColor = Color.DarkGray
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        GetPatients(navController = navController, paddingValues = paddingValues)
        //AdminPatientListContent(paddingValues = paddingValues)
    }
    DeletePatients()

}