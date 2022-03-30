package com.heronet.chatr.module

import com.heronet.chatr.util.Constants.BASE_URL
import com.microsoft.signalr.HubConnection
import com.microsoft.signalr.HubConnectionBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSignalRClient() : HubConnection {
        return HubConnectionBuilder.create("${BASE_URL}/chatHub").build()
    }
}