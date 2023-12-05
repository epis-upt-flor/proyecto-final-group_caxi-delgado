package com.xnical.combigo.presentation.screens.admin.clinic.list.componets

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.xnical.combigo.presentation.components.DefaultButton
import com.xnical.combigo.presentation.components.DefaultTextField
import com.xnical.combigo.R
import com.xnical.combigo.domain.model.Clinic

@Composable
fun AdminClinicListContent(navController: NavHostController ,clinics: List<Clinic>, paddingValues: PaddingValues ) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        items(
            items = clinics
        ) {clinic ->
            AdminClinicListItem(navController, clinic )
        }
    }

}

