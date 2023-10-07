package com.xnical.combigo.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.xnical.combigo.presentation.navigation.graph.admin.AdminNavGraph
import com.xnical.combigo.presentation.screens.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { AdminBottomBar(navController = navController)}
    ) { paddingValues ->
        AdminNavGraph(navController = navController)
    }
}