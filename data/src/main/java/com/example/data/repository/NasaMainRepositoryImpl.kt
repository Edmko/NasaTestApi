package com.example.data.repository

import com.example.data.remote.api.NasaApiService
import com.example.data.remote.response.toApod
import com.example.domain.entities.APOD
import com.example.domain.repository.NasaMainRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class NasaMainRepositoryImpl @Inject constructor(
    private val apiService: NasaApiService
): NasaMainRepository {

    override fun getCurrentApod(): Single<APOD> {
        return apiService.getCurrentApod().map { it.toApod() }
    }
}