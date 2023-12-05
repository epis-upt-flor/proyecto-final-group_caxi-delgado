package com.xnical.combigo.presentation.screens.admin.clinic.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.components.DefaultTopBar
import com.xnical.combigo.presentation.navigation.Graph
import com.xnical.combigo.presentation.screens.admin.clinic.list.componets.AdminClinicListContent
import com.xnical.combigo.presentation.screens.admin.clinic.list.componets.DeleteClinics
import com.xnical.combigo.presentation.screens.admin.clinic.list.componets.GetClinics

@Composable
fun AdminClinicListScreen(navController: NavHostController) {

    Scaffold(
        floatingActionButton ={
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = {
                    navController.navigate(route = Graph.ADMIN_CLINIC)
                },
                backgroundColor = Color.DarkGray
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    ) {paddingValues ->
        GetClinics(navController, paddingValues)
    }
    DeleteClinics()
}