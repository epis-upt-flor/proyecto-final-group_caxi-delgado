package com.xnical.combigo.presentation.screens.admin.patient.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.use_cases.patients.PatientsUseCase
import com.xnical.combigo.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminPatientListViewModel @Inject constructor(
    private val patientsUseCase: PatientsUseCase,
    private val savedStateHandle: SavedStateHandle,
): ViewModel(){

    var data = savedStateHandle.get<String>("clinic")
    var clinic = Clinic.fromJson(data!!)

    var patientsResponse by mutableStateOf<Resource<List<Patient>>?>(null)
        private set

    var patientDeleteResponse by mutableStateOf<Resource<Unit>?>(null)
        private set

    init {
        getPatients()
    }

    fun getPatients() = viewModelScope.launch {
        patientsResponse = Resource.Loading
        patientsUseCase.findByClinic(clinic.id!!).collect(){
            patientsResponse = it
            Log.d("AdminPatientListViewModel", "Data: ${patientsResponse}")
        }
    }

}