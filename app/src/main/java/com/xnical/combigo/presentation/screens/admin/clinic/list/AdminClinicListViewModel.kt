package com.xnical.combigo.presentation.screens.admin.clinic.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.use_cases.clinics.ClinicsUseCase
import com.xnical.combigo.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminClinicListViewModel @Inject constructor(private val clinicsUseCase: ClinicsUseCase): ViewModel() {

    var clinicsResponse by mutableStateOf<Resource<List<Clinic>>?>(null)
        private set

    var deleteClinicResponse by mutableStateOf<Resource<Unit>?>(null)
        private set


    init {
        getClinics()
    }
    fun getClinics() = viewModelScope.launch {
        clinicsResponse = Resource.Loading
        clinicsUseCase.getClinics().collect{data ->
            Log.d("GetClinics", "Data: ${data}")
            clinicsResponse = data
        }
    }

    fun deleteCategory(id: String) = viewModelScope.launch {
        deleteClinicResponse = Resource.Loading
        val result = clinicsUseCase.deleteClinic(id)
        deleteClinicResponse = result
    }
}