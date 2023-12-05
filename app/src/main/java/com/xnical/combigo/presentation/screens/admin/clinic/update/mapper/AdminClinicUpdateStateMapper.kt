package com.xnical.combigo.presentation.screens.admin.clinic.update.mapper

import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.presentation.screens.admin.clinic.create.AdminClinicCreateState
import com.xnical.combigo.presentation.screens.admin.clinic.update.AdminClinicUpdateState

fun AdminClinicUpdateState.toClinic(): Clinic{
    return Clinic(
        name = name,
        description = description
    )
}