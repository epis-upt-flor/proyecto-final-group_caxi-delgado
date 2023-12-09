package com.xnical.combigo.di

import com.xnical.combigo.domain.repository.AuthRepository
import com.xnical.combigo.domain.repository.ClinicsRepository
import com.xnical.combigo.domain.repository.PatientsRepository
import com.xnical.combigo.domain.repository.UsersRepository
import com.xnical.combigo.domain.use_cases.auth.AuthUseCase
import com.xnical.combigo.domain.use_cases.auth.GetSessionDataUseCase
import com.xnical.combigo.domain.use_cases.auth.LoginUseCase
import com.xnical.combigo.domain.use_cases.auth.LogoutUseCase
import com.xnical.combigo.domain.use_cases.auth.RegisterUseCase
import com.xnical.combigo.domain.use_cases.auth.SaveSessionUseCase
import com.xnical.combigo.domain.use_cases.auth.UpdateSessionUseCase
import com.xnical.combigo.domain.use_cases.clinics.ClinicsUseCase
import com.xnical.combigo.domain.use_cases.clinics.CreateClinicUseCase
import com.xnical.combigo.domain.use_cases.clinics.DeleteClinicUseCase
import com.xnical.combigo.domain.use_cases.clinics.GetClinicUseCase
import com.xnical.combigo.domain.use_cases.clinics.UpdateClinicUseCase
import com.xnical.combigo.domain.use_cases.clinics.UpdateClinicWithImageUseCase
import com.xnical.combigo.domain.use_cases.patients.CreatePatientUseCase
import com.xnical.combigo.domain.use_cases.patients.PatientsUseCase
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

    @Provides
    fun provideClinicsUseCase(clinicsRepository: ClinicsRepository) = ClinicsUseCase(
        createClinic = CreateClinicUseCase(clinicsRepository),
        getClinics = GetClinicUseCase(clinicsRepository),
        updateClinic = UpdateClinicUseCase(clinicsRepository),
        updateClinicWithImage = UpdateClinicWithImageUseCase(clinicsRepository),
        deleteClinic = DeleteClinicUseCase(clinicsRepository)
    )

    @Provides
    fun providePatientsUseCase(patientsRepository: PatientsRepository) = PatientsUseCase(
        createPatient = CreatePatientUseCase(patientsRepository)
    )


}