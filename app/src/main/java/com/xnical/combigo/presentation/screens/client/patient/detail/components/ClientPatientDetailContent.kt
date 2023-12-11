package com.xnical.combigo.presentation.screens.client.patient.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.xnical.combigo.presentation.components.DefaultButton
import com.xnical.combigo.presentation.components.DotsIndicator
import com.xnical.combigo.presentation.components.SliderView
import com.xnical.combigo.presentation.screens.client.patient.detail.ClientPatientDetailViewModel
import com.xnical.combigo.presentation.ui.theme.Gray200
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ClientPatientDetailContent(paddingValues: PaddingValues, vm: ClientPatientDetailViewModel = hiltViewModel()) {
    val state = rememberPagerState()

    Box(
        modifier = Modifier.padding(paddingValues).fillMaxSize()
    ) {
        Column(
        ) {
            SliderView(state = state, images = vm.patientImages)
            Spacer(modifier = Modifier.height(4.dp))
            DotsIndicator(totalDots = vm.patientImages.size, selectedIndex = state.currentPage)
        }
        Card(
            modifier = Modifier.padding(top = 420.dp),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp,
            ),
            backgroundColor = Color.White
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 7.dp),
                    text = vm.patient.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray200
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Descripcion",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.patient.description,
                    fontSize = 15.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray200
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Peso",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.patient.weight.toString(),
                    fontSize = 15.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray200
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Edad",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.patient.age.toString(),
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    DefaultButton(
                        modifier = Modifier.width(200.dp),
                        text = "ESCANEAR RMI",
                        onClick = {  }
                    )
                }

            }
        }
    }

    LaunchedEffect(key1 = state.currentPage) {
        delay(10000)
        var newPosition = state.currentPage + 1
        if (newPosition > vm.patientImages.size - 1) {
            newPosition = 0
        }
        state.animateScrollToPage(newPosition)
    }
}