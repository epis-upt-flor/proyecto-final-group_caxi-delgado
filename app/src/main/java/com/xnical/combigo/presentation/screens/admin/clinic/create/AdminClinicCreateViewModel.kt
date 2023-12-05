package com.xnical.combigo.presentation.screens.admin.clinic.create

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.use_cases.clinics.ClinicsUseCase
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.presentation.screens.admin.clinic.create.mapper.toClinic
import com.xnical.combigo.presentation.util.ComposeFileProvider
import com.xnical.combigo.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminClinicCreateViewModel @Inject constructor(
    private val clinicsUseCase: ClinicsUseCase,
    @ApplicationContext val context: Context
): ViewModel() {
    var state by mutableStateOf(AdminClinicCreateState())
        private set

    var clinicResponse by mutableStateOf<Resource<Clinic>?>(null)
        private set

    // IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    fun createClinic() = viewModelScope.launch{
        if (file != null) {
            clinicResponse = Resource.Loading
            val result = clinicsUseCase.createClinic(state.toClinic(), file!!)
            clinicResponse = result
        }

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

    fun clearForm() {
        state = state.copy(
            name = "",
            description = "",
            image = ""
        )
        clinicResponse = null
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }
}