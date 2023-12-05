package com.xnical.combigo.data.mapper

import com.xnical.combigo.data.dataSource.local.entity.ClinicEntity
import com.xnical.combigo.domain.model.Clinic


fun ClinicEntity.toClinic(): Clinic {
    return Clinic(
        id = id,
        name = name,
        description = description,
        image = image
    )
}

fun Clinic.toClinicEntity(): ClinicEntity {
    return ClinicEntity(
        id = id ?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}