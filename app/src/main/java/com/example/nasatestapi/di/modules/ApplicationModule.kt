package com.example.nasatestapi.di.modules

import com.example.data.remote.api.NasaApiServiceFactory
import com.example.nasatestapi.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    fun provideApiClient() = NasaApiServiceFactory.newInstance(BuildConfig.NASA_BASE_URL)
}