package com.xnical.combigo.presentation.screens.client.patient.list.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.presentation.navigation.screen.client.ClientPatientScreen
import com.xnical.combigo.presentation.screens.client.patient.list.ClientPatientListViewModel
import com.xnical.combigo.presentation.ui.theme.Gray200

@Composable
fun ClientPatientListItem(navController: NavHostController, patient: Patient, vm: ClientPatientListViewModel = hiltViewModel()) {

    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(150.dp)
            .clickable {
                navController.navigate(route = ClientPatientScreen.PatientDetail.passPatient(patient.toJson()))
            }
    ) {
        Row() {

            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = patient.name,
                    color = Color.Black,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = patient.description,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "REVISADO",
                    color = Color.Magenta,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = patient.image1,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier.padding(end = 80.dp),
            color = Gray200,
        )
    }


}