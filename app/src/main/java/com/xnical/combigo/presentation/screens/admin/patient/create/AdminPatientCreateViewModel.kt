package com.xnical.combigo.presentation.screens.admin.patient.create

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.presentation.util.ComposeFileProvider
import com.xnical.combigo.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminPatientCreateViewModel @Inject constructor(
    @ApplicationContext val context: Context,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var state by mutableStateOf(AdminPatientCreateState())
        private set

    var clinicResponse by mutableStateOf<Resource<Clinic>?>(null)
        private set

    var data = savedStateHandle.get<String>("clinic")
    var clinic = Clinic.fromJson(data!!)

    // IMAGENES
    var file1: File? = null
    var file2: File? = null
    var files: List<File> = listOf()
    val resultingActivityHandler = ResultingActivityHandler()

    init {
        state = state.copy(idClinic = clinic.id ?: "")
    }

    fun pickImage(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*") // URI
        if (result != null) {
            if (imageNumber == 1) {
                file1 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image1 = result.toString())
            }
            else if (imageNumber == 2) {
                file2 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image2 = result.toString())
            }
        }
    }

    fun takePhoto(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            if (imageNumber == 1) {
                state = state.copy(image1 = ComposeFileProvider.getPathFromBitmap(context, result))
                file1 = File(state.image1)
            }
            else if (imageNumber == 2) {
                state = state.copy(image2 = ComposeFileProvider.getPathFromBitmap(context, result))
                file2 = File(state.image2)
            }
        }
    }

    fun clearForm() {
        state = state.copy(
            name = "",
            description = "",
            image1 = "",
            image2 = "",
            weight = 0.0,
            age = 0,
        )
        //patientResponse = null
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }

    fun onWeightInput(input: String) {
        state = state.copy(weight = input.toDouble())
    }

    fun onAgeInput(input: String) {
        state = state.copy(age = input.toInt())
    }

}