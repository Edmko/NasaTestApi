package com.example.nasatestapi.di.modules

import com.example.domain.interactor.GetApodUseCase
import com.example.domain.repository.NasaMainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class UseCaseModule {

    @Provides
    fun getApodUseCase(nasaMainRepository: NasaMainRepository) = GetApodUseCase(nasaMainRepository)
}