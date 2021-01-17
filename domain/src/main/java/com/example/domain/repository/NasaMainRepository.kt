package com.example.domain.repository

import com.example.domain.entities.APOD
import io.reactivex.rxjava3.core.Single

interface NasaMainRepository {
    fun getCurrentApod(): Single<APOD>
}