package com.example.nasatestapi.di.modules

import com.example.data.repository.NasaMainRepositoryImpl
import com.example.domain.repository.NasaMainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    internal abstract fun provideNasaMainRepository(nasaMainRepository: NasaMainRepositoryImpl): NasaMainRepository

}