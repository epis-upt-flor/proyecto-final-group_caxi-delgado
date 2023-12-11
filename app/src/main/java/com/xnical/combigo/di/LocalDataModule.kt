package com.xnical.combigo.di

import com.xnical.combigo.data.dataSource.local.AuthLocalDataSource
import com.xnical.combigo.data.dataSource.local.AuthLocalDataSourceImpl
import com.xnical.combigo.data.dataSource.local.ClinicsLocalDataSource
import com.xnical.combigo.data.dataSource.local.ClinicsLocalDataSourceImpl
import com.xnical.combigo.data.dataSource.local.PatientsLocalDataSource
import com.xnical.combigo.data.dataSource.local.PatientsLocalDataSourceImpl
import com.xnical.combigo.data.dataSource.local.dao.ClinicsDao
import com.xnical.combigo.data.dataSource.local.dao.PatientsDao
import com.xnical.combigo.data.dataSource.local.datastore.AuthDatastore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideClinicsLocalDataSource(clinicsDao: ClinicsDao): ClinicsLocalDataSource = ClinicsLocalDataSourceImpl(clinicsDao)

    @Provides
    fun providePatientsLocalDataSource(patientsDao: PatientsDao): PatientsLocalDataSource = PatientsLocalDataSourceImpl(patientsDao)
}