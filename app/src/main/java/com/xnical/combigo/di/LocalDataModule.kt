package com.xnical.combigo.di

import com.xnical.combigo.data.repository.dataSource.AuthLocalDataSource
import com.xnical.combigo.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import com.xnical.combigo.data.datastore.AuthDatastore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

}