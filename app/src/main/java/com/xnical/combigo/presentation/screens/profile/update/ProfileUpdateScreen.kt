package com.xnical.combigo.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.components.DefaultTopBar
import com.xnical.combigo.presentation.screens.profile.info.components.ProfileContent
import com.xnical.combigo.presentation.screens.profile.update.components.ProfileUpdateContent
import com.xnical.combigo.presentation.screens.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam: String) {

    Log.d("ProfileUpdateScreen","Data: $userParam")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar perfil",
                navController = navController,
                upAvailable = true
            )
        }
    ) {paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)
    }
    UpdateUser()
}