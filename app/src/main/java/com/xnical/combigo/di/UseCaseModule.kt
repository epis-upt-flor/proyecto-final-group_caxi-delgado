package com.xnical.combigo.di



import com.xnical.combigo.domain.repository.AuthRepository
import com.xnical.combigo.domain.use_cases.auth.AuthUseCase
import com.xnical.combigo.domain.use_cases.auth.GetSessionDataUseCase
import com.xnical.combigo.domain.use_cases.auth.LoginUseCase
import com.xnical.combigo.domain.use_cases.auth.RegisterUseCase
import com.xnical.combigo.domain.use_cases.auth.SaveSessionUseCase
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
        getSessionData = GetSessionDataUseCase(authRepository)
    )

}