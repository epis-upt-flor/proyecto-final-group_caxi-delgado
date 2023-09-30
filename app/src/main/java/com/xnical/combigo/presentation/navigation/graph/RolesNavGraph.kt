package com.xnical.combigo.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.navigation.screen.RolesScreen
import com.xnical.combigo.presentation.screens.admin.home.AdminHomeScreen
import com.xnical.combigo.presentation.screens.client.home.ClientHomeScreen


import com.xnical.combigo.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){
        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }

        composable(route= Graph.CLIENT){
            ClientHomeScreen()
        }

        composable(route= Graph.ADMIN){
            AdminHomeScreen()
        }
    }
}