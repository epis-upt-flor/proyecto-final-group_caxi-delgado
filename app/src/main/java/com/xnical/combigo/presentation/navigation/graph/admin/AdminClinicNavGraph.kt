package com.xnical.combigo.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.navigation.screen.admin.AdminClinicScreen
import com.xnical.combigo.presentation.screens.admin.clinic.create.AdminClinicCreateScreen
import com.xnical.combigo.presentation.screens.admin.clinic.update.AdminClinicUpdateScreen
import com.xnical.combigo.presentation.screens.admin.patient.create.AdminPatientCreateScreen
import com.xnical.combigo.presentation.screens.admin.patient.list.AdminPatientListScreen

fun NavGraphBuilder.AdminClinicNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CLINIC,
        startDestination = AdminClinicScreen.ClinicCreate.route
    ){

        composable(route = AdminClinicScreen.ClinicCreate.route){
            AdminClinicCreateScreen(navController)
        }

        composable(
            route = AdminClinicScreen.ClinicUpdate.route,
            arguments = listOf(navArgument("clinic") {
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("clinic")?.let {
                AdminClinicUpdateScreen(navController, it)
            }
        }

        composable(
            route = AdminClinicScreen.PatientList.route,
            arguments = listOf(navArgument("clinic") {
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("clinic")?.let {
                AdminPatientListScreen(navController, it)
            }
        }

        composable(
            route = AdminClinicScreen.PatientCreate.route,
            arguments = listOf(navArgument("clinic") {
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("clinic")?.let {
                AdminPatientCreateScreen(navController, it)
            }
        }

    }
}