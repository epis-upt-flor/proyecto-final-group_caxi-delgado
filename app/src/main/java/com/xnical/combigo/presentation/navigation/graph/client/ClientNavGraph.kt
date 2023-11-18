package com.xnical.combigo.presentation.navigation.graph.client

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.navigation.graph.profile.ProfileNavGraph
import com.xnical.combigo.presentation.navigation.screen.client.ClientScreen
import com.xnical.combigo.presentation.screens.client.clinic.list.ClientClinicListScreen
import com.xnical.combigo.presentation.screens.client.patient.list.ClientPatientListScreen
import com.xnical.combigo.presentation.screens.profile.info.ProfileScreen

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

        ProfileNavGraph(navController)
    }
}