package com.xnical.combigo.presentation.screens.admin.clinic.update

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.use_cases.clinics.ClinicsUseCase
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.presentation.screens.admin.clinic.update.mapper.toClinic
import com.xnical.combigo.presentation.util.ComposeFileProvider
import com.xnical.combigo.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminClinicUpdateViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val clinicsUseCase: ClinicsUseCase,
    @ApplicationContext val context: Context
): ViewModel() {
    var state by mutableStateOf(AdminClinicUpdateState())
        private set

    var clinicResponse by mutableStateOf<Resource<Clinic>?>(null)
        private set

    // IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var data = savedStateHandle.get<String>("clinic")
    val clinic = Clinic.fromJson(data!!)

    init {
        state = state.copy(
            name = clinic.name,
            image = clinic.image!!,
            description = clinic.description
        )
    }

    fun onUpdate()  {
        if (file != null) {
            updateClinicWithImage()
        }
        else {
            updateClinic()
        }
    }

    fun updateClinic() = viewModelScope.launch {
        clinicResponse = Resource.Loading
        val result = clinicsUseCase.updateClinic(clinic.id ?: "", state.toClinic())
        clinicResponse = result
    }

    fun updateClinicWithImage() = viewModelScope.launch {
        clinicResponse = Resource.Loading
        val result = clinicsUseCase.updateClinicWithImage(clinic.id ?: "", state.toClinic(), file!!)
        clinicResponse = result
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*") // URI
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }


    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }
}