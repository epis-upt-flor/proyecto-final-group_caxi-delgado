package com.xnical.combigo.presentation.screens.admin.clinic.list.componets

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun AdminClinicListContent(paddingValues: PaddingValues,  ) {
    val activity = LocalContext.current as? Activity

    Text(
        modifier = Modifier.padding(paddingValues = paddingValues),
        text = "Admin CLINICAS xddd"
    )


}

