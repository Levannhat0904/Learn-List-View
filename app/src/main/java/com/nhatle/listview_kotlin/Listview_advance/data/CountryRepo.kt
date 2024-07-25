package com.nhatle.listview_kotlin.Listview_advance.data

class CountryRepo(private val localDataSource: LocalDataSource) {
    fun loadCountries():List<Country> {
        return localDataSource.loadCountry()
    }
}