package com.xnical.combigo.presentation.screens.client.patient.list.componets

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ClientPatientListContent(paddingValues: PaddingValues) {
    val activity = LocalContext.current as? Activity

    Text(
        modifier = Modifier.padding(paddingValues = paddingValues),
        text = "CLIENT PRODUCT LIST SCREEN"
    )


}

