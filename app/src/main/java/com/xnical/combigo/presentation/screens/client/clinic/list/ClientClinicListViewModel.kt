package com.xnical.combigo.presentation.screens.client.clinic.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.use_cases.clinics.ClinicsUseCase
import com.xnical.combigo.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientClinicListViewModel @Inject constructor(private val clinicsUseCase: ClinicsUseCase) : ViewModel() {

    var clinicsResponse by mutableStateOf<Resource<List<Clinic>>?>(null)
        private set

    init {
        getClinics()
    }

    fun getClinics() = viewModelScope.launch {
        clinicsResponse = Resource.Loading
        clinicsUseCase.getClinics().collect() {
            clinicsResponse = it
        }
    }
}