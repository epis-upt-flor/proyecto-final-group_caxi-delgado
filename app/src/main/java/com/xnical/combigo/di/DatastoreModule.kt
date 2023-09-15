package com.xnical.combigo.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.xnical.combigo.core.Config.AUTH_PREFERENCE
import com.xnical.combigo.data.datastore.AuthDatastore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    // Proporciona una instancia de DataStore de preferencias.
    @Provides
    @Singleton
    fun providePreferenceDatastore(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(AUTH_PREFERENCE)
            }
        )

    // Proporciona una instancia de AuthDatastore que utiliza DataStore para gestionar datos de autenticación.
    @Provides
    @Singleton
    fun provideAuthDatastore(dataStore: DataStore<Preferences>) = AuthDatastore(dataStore)


}