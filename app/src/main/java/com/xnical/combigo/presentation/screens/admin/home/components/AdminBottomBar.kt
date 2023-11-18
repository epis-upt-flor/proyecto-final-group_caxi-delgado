package com.xnical.combigo.presentation.screens.admin.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.xnical.combigo.presentation.navigation.screen.admin.AdminScreen


@Composable
fun AdminBottomBar(navController: NavHostController){

    val screens = listOf(
        AdminScreen.PatientList,
        AdminScreen.ClinicList,
        AdminScreen.Profile,
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination){
        BottomNavigation() {
            screens.forEach{ screen ->
                AdminBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}