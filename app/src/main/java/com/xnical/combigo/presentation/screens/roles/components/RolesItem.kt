package com.xnical.combigo.presentation.screens.roles.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.xnical.combigo.domain.model.Rol

@Composable
fun RolesItem (rol : Rol){
    Spacer(modifier = Modifier.height(20.dp))
    AsyncImage(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        model = rol.image, contentDescription = ""
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = rol.name,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
}