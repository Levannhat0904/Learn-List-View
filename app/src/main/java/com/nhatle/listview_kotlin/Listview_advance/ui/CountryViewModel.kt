package com.nhatle.listview_kotlin.Listview_advance.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nhatle.listview_kotlin.Listview_advance.data.Country
import com.nhatle.listview_kotlin.Listview_advance.data.CountryRepo

class CountryViewModel(private val repository: CountryRepo):ViewModel() {
   private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>
        get() = _countries
    fun loadCountries(){
        _countries.value = repository.loadCountries()
    }
    class Factory(
        private val repository: CountryRepo
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CountryViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}