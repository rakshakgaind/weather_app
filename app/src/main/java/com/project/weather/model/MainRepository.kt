package com.project.weather.model

import com.project.weather.rest.WeatherRetrofitConfig

class MainRepository(private val retrofitService: WeatherRetrofitConfig) {

    fun fetchCity(city: String) = retrofitService.fetchCity(city)

    fun fetchLocationPhone(lat: String, lon: String) = retrofitService.fetchLocationPhone(lat, lon)
}