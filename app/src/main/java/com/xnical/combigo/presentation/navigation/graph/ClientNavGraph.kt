package com.xnical.combigo.presentation.navigation.graph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.navigation.screen.ClientScreen
import com.xnical.combigo.presentation.screens.client.clinic.list.ClientClinicListScreen
import com.xnical.combigo.presentation.screens.client.patient.list.ClientPatientListScreen
import com.xnical.combigo.presentation.screens.profile.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.PatientList.route
    ){
        composable(route = ClientScreen.PatientList.route) {
            ClientPatientListScreen()
        }

        composable(route = ClientScreen.ClinicList.route) {
            ClientClinicListScreen()
        }

        composable(route = ClientScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}