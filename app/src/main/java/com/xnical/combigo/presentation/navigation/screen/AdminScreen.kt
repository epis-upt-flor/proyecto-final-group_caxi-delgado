package com.xnical.combigo.presentation.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route : String,
    val title : String,
    val icon: ImageVector
){
    object ClinicList : AdminScreen(
        route = "admin/clinic/list",
        title = "Clinicas",
        icon = Icons.Default.List
    )
    object PatientList : AdminScreen(
        route = "admin/patient/list",
        title = "Pacientes",
        icon = Icons.Default.Face
    )
    object Profile : AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
