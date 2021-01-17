package com.example.nasatestapi.apod

import androidx.hilt.lifecycle.ViewModelInject
import com.example.domain.entities.APOD
import com.example.domain.interactor.GetApodUseCase
import com.example.domain.repository.NasaMainRepository
import com.example.nasatestapi.base.BaseViewModel
import com.jakewharton.rxrelay3.BehaviorRelay
import com.jakewharton.rxrelay3.Relay
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.kotlin.addTo
import timber.log.Timber

class ApodViewModel @ViewModelInject constructor(private val getApodUseCase: GetApodUseCase): BaseViewModel() {

    val imageResult = UseCaseResult<APOD>()
    init {
        fetchImage()
    }
    private fun fetchImage(){
        getApodUseCase.subscribe(explodeTo(imageResult)).autoDispose()

    }
}