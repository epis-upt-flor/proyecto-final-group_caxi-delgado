package com.xnical.combigo.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.navigation.screen.AuthScreen
import com.xnical.combigo.presentation.screens.auth.login.LoginScreen
import com.xnical.combigo.presentation.screens.auth.register.RegisterScreen
import com.xnical.combigo.presentation.screens.home.HomeScreen
import com.xnical.combigo.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController)
        }
        composable(route = AuthScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = AuthScreen.Roles.route) {
            RolesScreen(navController)
        }
    }
}