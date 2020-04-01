/*
 * Copyright © 2020 NHSX. All rights reserved.
 */

package com.example.colocate.di.module

import android.content.Context
import androidx.room.Room
import com.example.colocate.ble.SaveContactWorker
import com.example.colocate.persistence.AppDatabase
import com.example.colocate.persistence.ContactEventDao
import com.example.colocate.persistence.ResidentIdProvider
import com.example.colocate.persistence.SharedPreferencesResidentIdProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named

@Module
class PersistenceModule(private val applicationContext: Context) {

    @Provides
    fun provideDatabase() =
        Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "event-database")
            .build()

    @Provides
    fun provideContactEventDao(database: AppDatabase): ContactEventDao =
        database.contactEventDao()

    @Provides
    fun provideResidentIdProvider(): ResidentIdProvider =
        SharedPreferencesResidentIdProvider(applicationContext)

    @Provides
    fun provideSaveContactWorker(
        contactEventDao: ContactEventDao,
        @Named(AppModule.DISPATCHER_IO) ioDispatcher: CoroutineDispatcher
    ): SaveContactWorker =
        SaveContactWorker(ioDispatcher, contactEventDao)
}
