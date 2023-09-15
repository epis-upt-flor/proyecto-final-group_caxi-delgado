package com.xnical.combigo.domain.use_cases.auth

//AGRUPA CASOS DE USO EN UNA CLASS DE DATOS: FACILITA EL ACCESO EN DIFERENTES PARTES DE LA APLICACION
data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase
)
