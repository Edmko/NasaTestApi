package com.example.domain.interactor

import com.example.domain.entities.APOD
import com.example.domain.repository.NasaMainRepository
import io.reactivex.rxjava3.core.Single

class GetApodUseCase(private val nasaMainRepository: NasaMainRepository): UseCase<Nothing, APOD>() {

    override fun createSingle(params: Nothing?): Single<APOD> {
        return nasaMainRepository.getCurrentApod()
    }
}