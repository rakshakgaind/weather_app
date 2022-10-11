package com.project.weather.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.weather.R
import com.project.weather.databinding.FragmentHomeBinding
import kotlin.math.roundToInt

class ResultFragment : Fragment(R.layout.fragment_home) {
    lateinit var binding: FragmentHomeBinding
    val args: ResultFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val weather = args.weather


        binding.apply {
            homeTxtCity.text = weather.name
            homeTxtTemp.text = "${weather.main.temp.roundToInt()}C°"
            homeTxtWeather.text = weather.weather[0].main
            homeTxtStats.text = weather.weather[0].description
            homeTxtFeelLike.text = "${weather.main.feels_like.roundToInt()}C°"
            homeTxtHumidity.text = "${weather.main.humidity}%"
            homeTxtWind.text = "${weather.wind.speed} m/s"
        }


        when (weather.weather[0].icon) {
            "09d", "10d", "11d", "09n", "10n", "11n" -> binding.homeImgNow.setImageResource(
                R.drawable.rain
            )
            "01d" -> binding.homeImgNow.setImageResource(R.drawable.sun)
            "02d", "03d" -> binding.homeImgNow.setImageResource(R.drawable.sun_cloud)
            "01n" -> binding.homeImgNow.setImageResource(R.drawable.moon)
            "02n", "03n" -> binding.homeImgNow.setImageResource(R.drawable.moon_cloud)
            "04d", "13d", "50d", "04n", "13n", "50n" -> binding.homeImgNow.setImageResource(
                R.drawable.cloud
            )
        }


    }

    override fun onStart() {
        activity?.findViewById<BottomNavigationView>(R.id.main_nav_bottom)?.visibility = View.GONE
        super.onStart()
    }

    override fun onPause() {
        activity?.findViewById<BottomNavigationView>(R.id.main_nav_bottom)?.visibility = View.VISIBLE
        super.onPause()
    }


}