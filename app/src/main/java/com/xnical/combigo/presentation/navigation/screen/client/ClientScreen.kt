package com.xnical.combigo.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route : String,
    val title : String,
    val icon: ImageVector
){
    object ClinicList : ClientScreen(
        route = "client/clinic/list",
        title = "Clinicas",
        icon = Icons.Default.List
    )
    object PatientList : ClientScreen(
        route = "client/patient/list",
        title = "Pacientes",
        icon = Icons.Default.Face
    )
    object Profile : ClientScreen(
        route = "client/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
    object ProfileUpdate : ClientScreen(
        route = "client/profile/update",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
