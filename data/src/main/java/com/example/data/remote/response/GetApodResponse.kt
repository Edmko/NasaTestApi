package com.example.data.remote.response

import com.example.domain.entities.APOD
import com.google.gson.annotations.SerializedName
import java.util.*

data class GetApodResponse(
    val date: String,
    val explanation: String,
    @SerializedName("hdurl") val urlHd: String,
    @SerializedName("url") val url: String,
    @SerializedName("media_type") val mediaType: String,
    @SerializedName("service_version") val serviceVersion: String,
    val title: String
)

fun GetApodResponse.toApod() : APOD{
    val type = when (mediaType) {
        "image" -> APOD.ApodType.IMAGE
        else -> APOD.ApodType.IMAGE
    }
    return APOD(
        date = Date(),
        explanation = explanation,
        image = url,
        imageHd = urlHd,
        type = type,
        version = serviceVersion,
        title = title
    )
}