package com.xnical.combigo.presentation.screens.auth.register.mapper

import com.xnical.combigo.domain.model.User
import com.xnical.combigo.presentation.screens.auth.register.RegisterState


fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password
    )
}