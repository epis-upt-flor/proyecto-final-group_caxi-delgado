package com.xnical.combigo.presentation.screens.client.patient.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.use_cases.patients.PatientsUseCase
import com.xnical.combigo.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientPatientListViewModel @Inject constructor(private val patientsUseCase: PatientsUseCase): ViewModel() {

    var patientsResponse by mutableStateOf<Resource<List<Patient>>?>(null)
        private set

    var search by mutableStateOf("")

    fun getPatients() = viewModelScope.launch {
        patientsResponse = Resource.Loading
        patientsUseCase.findAll().collect() {
            Log.d("ClientPatientListViewModel", "Data: $it")
            patientsResponse = it
        }
    }
}