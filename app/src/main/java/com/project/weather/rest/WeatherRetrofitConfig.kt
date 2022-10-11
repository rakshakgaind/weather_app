package com.project.weather.rest

import com.project.weather.model.WeatherApiResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface WeatherRetrofitConfig {

    //weather?q={city}&units=metric&appid=fccbdc41f2bb5a0b09266288a1a820ce&lang=pt_br
    @GET("weather")
    fun fetchCity(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = "85b090ebdc7f6e11c43252c5efb6d063",
        @Query("lang") lang: String = "en-au"

    ): Call<WeatherApiResult>

    //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
    @GET("weather")
    fun fetchLocationPhone(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = "85b090ebdc7f6e11c43252c5efb6d063",
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "en-au"
    ): Call<WeatherApiResult>


    companion object {

        val retrofitService: WeatherRetrofitConfig by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(WeatherRetrofitConfig::class.java)

        }

        fun getInstance(): WeatherRetrofitConfig {
            return retrofitService
        }

    }
}