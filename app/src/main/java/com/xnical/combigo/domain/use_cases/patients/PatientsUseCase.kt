package com.xnical.combigo.domain.use_cases.patients

data class PatientsUseCase(
    val createPatient: CreatePatientUseCase,
    val findByClinic: FindByClinicUseCase
)
