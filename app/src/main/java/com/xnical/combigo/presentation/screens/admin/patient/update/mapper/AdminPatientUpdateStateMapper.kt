package com.xnical.combigo.presentation.screens.admin.patient.update.mapper

import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.presentation.screens.admin.patient.create.AdminPatientCreateState
import com.xnical.combigo.presentation.screens.admin.patient.update.AdminPatientUpdateState

fun AdminPatientUpdateState.toPatient(): Patient {
    return Patient(
        name = name,
        description = description,
        idClinic = idClinic,
        weight = weight,
        age = age,
        imagesToUpdate = imagesToUpdate.toList(),
        image1 = image1,
        image2 = image2
    )
}