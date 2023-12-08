package com.xnical.combigo.presentation.screens.admin.patient.create

data class AdminPatientCreateState(
    val name: String = "",
    val description: String = "",
    val idClinic: String = "",
    val image1: String = "",
    val image2: String = "",
    val weight: Double = 0.0,
    val age: Int = 0,
)
