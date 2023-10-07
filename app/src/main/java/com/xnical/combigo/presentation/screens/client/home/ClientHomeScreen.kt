package com.xnical.combigo.presentation.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.xnical.combigo.presentation.navigation.graph.client.ClientNavGraph
import com.xnical.combigo.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { ClientBottomBar(navController = navController)}
    ) {  paddingValues ->
        ClientNavGraph(navController = navController)
    }
}