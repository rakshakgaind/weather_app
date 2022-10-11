package com.project.weather.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class WeatherApiResult(
    val coord: Coordiante,
    val weather: List<Weather>,
    val sys: Sys,
    val main: Main,
    val wind: Wind,
    val name: String
) : Parcelable

@Parcelize
data class Wind(
    val speed: Float
) : Parcelable

@Parcelize
data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
) : Parcelable

@Parcelize
data class Coordiante(
    val lon: Double,
    val lat: Double
) : Parcelable

@Parcelize
data class Main(
    val temp: Float,
    val feels_like: Float,
    val humidity: Int,
) : Parcelable

@Parcelize
data class Sys(val country: String) : Parcelable