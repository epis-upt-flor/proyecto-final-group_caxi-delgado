package com.xnical.combigo.presentation.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold(
    ) {paddingValues ->
        ProfileContent(paddingValues = paddingValues, navController = navController)
    }

}