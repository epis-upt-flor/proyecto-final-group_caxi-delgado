package com.xnical.combigo.presentation.screens.admin.clinic.create.mapper

import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.presentation.screens.admin.clinic.create.AdminClinicCreateState

fun AdminClinicCreateState.toClinic(): Clinic{
    return Clinic(
        name = name,
        description = description
    )
}