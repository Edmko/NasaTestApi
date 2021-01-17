package com.example.domain.entities

import java.util.*

data class APOD (
    val date: Date,
    val explanation: String,
    val imageHd : String,
    val image: String,
    val type: ApodType,
    val version: String,
    val title: String
    ){
    enum class ApodType{IMAGE}
}