package com.xnical.combigo.presentation.screens.admin.patient.create.mapper

import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.presentation.screens.admin.patient.create.AdminPatientCreateState

fun AdminPatientCreateState.toPatient(): Patient {
    return Patient(
        name = name,
        description = description,
        idClinic = idClinic,
        weight = weight,
        age = age
    )
}