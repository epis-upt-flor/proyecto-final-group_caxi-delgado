package com.xnical.combigo.presentation.screens.profile.update.mapper

import com.xnical.combigo.domain.model.User
import com.xnical.combigo.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}