package com.xnical.combigo.presentation.screens.client.clinic.list.componets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.xnical.combigo.domain.model.Clinic

@Composable
fun ClientClinicListContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    clinics: List<Clinic>
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = clinics
        ) {clinic ->
            ClientClinicListItem(
                navController = navController,
                clinic = clinic
            )
        }
    }

}

