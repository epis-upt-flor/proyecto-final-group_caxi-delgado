package com.xnical.combigo.domain.use_cases.patients

data class PatientsUseCase(
    val createPatient: CreatePatientUseCase,
    val findByClinic: FindByClinicUseCase,
    val findAll: FindAllUseCase,
    val updatePatient: UpdatePatientUseCase,
    val updatePatientWithImage: UpdatePatientWithImageUseCase,
    val deletePatient: DeletePatientUseCase
)
