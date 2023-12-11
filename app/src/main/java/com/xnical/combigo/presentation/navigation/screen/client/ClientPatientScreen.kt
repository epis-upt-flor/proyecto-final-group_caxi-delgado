package com.xnical.combigo.presentation.navigation.screen.client

sealed class ClientPatientScreen(val route : String){

    object PatientDetail : ClientPatientScreen("client/patients/detail/{patient}"){
        fun passPatient(patient: String) = "client/patients/detail/$patient"
    }

}
