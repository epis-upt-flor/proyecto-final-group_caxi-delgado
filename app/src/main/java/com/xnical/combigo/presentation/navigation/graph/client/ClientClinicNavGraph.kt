package com.xnical.combigo.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.navigation.screen.admin.AdminClinicScreen
import com.xnical.combigo.presentation.navigation.screen.client.ClientClinicScreen
import com.xnical.combigo.presentation.screens.admin.clinic.create.AdminClinicCreateScreen
import com.xnical.combigo.presentation.screens.admin.clinic.update.AdminClinicUpdateScreen
import com.xnical.combigo.presentation.screens.admin.patient.create.AdminPatientCreateScreen
import com.xnical.combigo.presentation.screens.admin.patient.list.AdminPatientListScreen
import com.xnical.combigo.presentation.screens.admin.patient.update.AdminPatientUpdateScreen
import com.xnical.combigo.presentation.screens.client.patient.listByClinic.ClientPatientByClinicListScreen

fun NavGraphBuilder.ClientClinicNavGraph(navController: NavHostController){
    navigation(
        route = Graph.CLIENT_CLINIC,
        startDestination = ClientClinicScreen.PatientList.route
    ){

        composable(
            route = ClientClinicScreen.PatientList.route,
            arguments = listOf(navArgument("clinic") {
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("clinic")?.let {
                ClientPatientByClinicListScreen(navController, it)
            }
        }

    }
}