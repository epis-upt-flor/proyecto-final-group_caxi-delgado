package com.xnical.combigo.presentation.screens.admin.patient.update

data class AdminPatientUpdateState(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val idClinic: String = "",
    val image1: String = "",
    val image2: String = "",
    val weight: Double = 0.0,
    val age: Int = 0,
    val imagesToUpdate: MutableList<Int> = mutableListOf()
)
