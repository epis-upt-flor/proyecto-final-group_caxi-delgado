package com.xnical.combigo.di

import com.xnical.combigo.domain.repository.AuthRepository
import com.xnical.combigo.domain.repository.UsersRepository
import com.xnical.combigo.domain.use_cases.auth.AuthUseCase
import com.xnical.combigo.domain.use_cases.auth.GetSessionDataUseCase
import com.xnical.combigo.domain.use_cases.auth.LoginUseCase
import com.xnical.combigo.domain.use_cases.auth.LogoutUseCase
import com.xnical.combigo.domain.use_cases.auth.RegisterUseCase
import com.xnical.combigo.domain.use_cases.auth.SaveSessionUseCase
import com.xnical.combigo.domain.use_cases.auth.UpdateSessionUseCase
import com.xnical.combigo.domain.use_cases.users.UpdateUserUseCase
import com.xnical.combigo.domain.use_cases.users.UpdateUserWithImageUseCase
import com.xnical.combigo.domain.use_cases.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )

}