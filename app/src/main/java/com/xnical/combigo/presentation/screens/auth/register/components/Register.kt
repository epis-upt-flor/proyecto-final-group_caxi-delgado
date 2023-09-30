package com.xnical.combigo.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.xnical.combigo.domain.util.Resource

import com.xnical.combigo.presentation.components.ProgressBar
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.navigation.screen.AuthScreen
import com.xnical.combigo.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navController: NavHostController, vm: RegisterViewModel = hiltViewModel()) {

    when(val response = vm.registerResponse) {
        Resource.Loading -> { ProgressBar() }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                navController.navigate(route = Graph.CLIENT){
                    popUpTo(Graph.AUTH) {inclusive = true}
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }

}