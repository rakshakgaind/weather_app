package com.project.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.weather.model.MainRepository
import com.project.weather.model.IViewProgress

class SearchViewModelFactory(private val view: IViewProgress, private val repository: MainRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(this.view,this.repository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }

}