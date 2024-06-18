package com.xnical.combigo.presentation.navigation.screen.client

sealed class ClientClinicScreen(val route : String){

    object PatientList : ClientClinicScreen("client/clinic/patients/list/{clinic}"){
        fun passClinic(clinic: String) = "client/clinic/patients/list/$clinic"
    }

}
