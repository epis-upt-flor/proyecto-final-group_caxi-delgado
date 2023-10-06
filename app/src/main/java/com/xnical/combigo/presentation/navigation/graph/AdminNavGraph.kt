package com.xnical.combigo.presentation.navigation.graph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.navigation.screen.AdminScreen
import com.xnical.combigo.presentation.screens.admin.clinic.list.AdminClinicListScreen
import com.xnical.combigo.presentation.screens.admin.patient.list.AdminPatientListScreen
import com.xnical.combigo.presentation.screens.profile.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.PatientList.route
    ){
        composable(route = AdminScreen.PatientList.route) {
            AdminPatientListScreen()
        }

        composable(route = AdminScreen.ClinicList.route) {
            AdminClinicListScreen()
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}