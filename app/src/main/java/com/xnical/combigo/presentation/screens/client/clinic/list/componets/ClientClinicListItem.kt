package com.xnical.combigo.presentation.screens.client.clinic.list.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.xnical.combigo.domain.model.Clinic

@Composable
fun ClientClinicListItem(navController: NavHostController, clinic: Clinic){

    Card(
        modifier = Modifier
            .padding(bottom = 15.dp),
            //.clickable { navController.navigate(route = ClientClinicScreen.ProductList.passCategory(category.toJson())) },
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp)
    ) {

        Column {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = clinic.image,
                contentDescription = "",
//                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                text = clinic.name,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                text = clinic.description,
                fontSize = 14.sp,
                color = Color.Gray
            )

        }

    }
}