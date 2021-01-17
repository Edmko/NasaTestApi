package com.example.data.remote.api

import com.example.data.remote.response.GetApodResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApiService {
    @GET("/planetary/apod?api_key=8jLfavCteaPYmrtrLXQjjaRSZcncB4baTfELNzo4")
    fun getCurrentApod( ): Single<GetApodResponse>
}