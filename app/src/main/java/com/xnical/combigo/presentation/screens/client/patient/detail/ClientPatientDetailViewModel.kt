package com.xnical.combigo.presentation.screens.client.patient.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.xnical.combigo.domain.model.Patient
import javax.inject.Inject

class ClientPatientDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel(){

    var data = savedStateHandle.get<String>("patient")
    var patient = Patient.fromJson(data!!)
    var patientImages = listOf<String>(patient.image1 ?: "", patient.image2 ?: "")

}