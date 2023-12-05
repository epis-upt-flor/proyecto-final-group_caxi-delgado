package com.xnical.combigo.presentation.navigation.screen.admin

sealed class AdminClinicScreen(val route : String){

    object ClinicCreate : AdminClinicScreen("admin/clinic/create")
    object ClinicUpdate : AdminClinicScreen("admin/clinic/update/{clinic}"){
        fun passClinic(clinic: String) = "admin/clinic/update/$clinic"
    }

}