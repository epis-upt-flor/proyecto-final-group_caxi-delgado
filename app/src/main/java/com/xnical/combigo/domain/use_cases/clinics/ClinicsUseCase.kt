package com.xnical.combigo.domain.use_cases.clinics

data class ClinicsUseCase(
    val createClinic: CreateClinicUseCase,
    val getClinics: GetClinicUseCase,
    val updateClinic: UpdateClinicUseCase,
    val updateClinicWithImage: UpdateClinicWithImageUseCase,
    val deleteClinic: DeleteClinicUseCase
)
