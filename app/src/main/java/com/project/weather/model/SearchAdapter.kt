package com.project.weather.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.weather.R
import com.project.weather.databinding.ItemResultBinding
import kotlin.math.roundToInt

class SearchAdapter(val lista: List<WeatherApiResult>, private val onItemClicked: (WeatherApiResult) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private class ResultViewHolder(val binding: ItemResultBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(city: WeatherApiResult, onItemClicked: (WeatherApiResult) -> Unit) {

            binding.apply {
                itemTxtCity.text=city.name
                itemTxtCountry.text=city.sys.country
                itemTxtStatus.text=city.weather[0].main+" Sky"
                itemTxtTemp.text="C° ${city.main.temp.roundToInt()}"
            }
            when (city.weather[0].icon) {

                "09d", "10d", "11d", "09n", "10n", "11n" -> binding.itemImgTemp.setImageResource(R.drawable.rain)
                "01d" -> binding.itemImgTemp.setImageResource(R.drawable.sun)
                "02d", "03d" -> binding.itemImgTemp.setImageResource(R.drawable.sun_cloud)
                "01n" -> binding.itemImgTemp.setImageResource(R.drawable.moon)
                "02n", "03n" -> binding.itemImgTemp.setImageResource(R.drawable.moon_cloud)
                "04d", "13d", "50d", "04n", "13n", "50n" -> binding.itemImgTemp.setImageResource(R.drawable.cloud)
            }

            itemView.setOnClickListener {
                onItemClicked(city)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ResultViewHolder -> {
                holder.bind(lista[position], onItemClicked)
            }
        }
    }

    override fun getItemCount() = lista.size
}