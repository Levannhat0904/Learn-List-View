package com.nhatle.listview_kotlin.Listview_advance.ui

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.nhatle.listview_kotlin.Listview_advance.data.CountryRepo
import com.nhatle.listview_kotlin.Listview_advance.data.LocalDataSource
import com.nhatle.listview_kotlin.R

class ListviewAdvanceActivity : AppCompatActivity() {
    private lateinit var countryBaseAdapter: CountryBaseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listview_advance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpListView()
        observeData()
    }
    fun setUpListView() {
        val listview = findViewById<ListView>(R.id.list_country)
        countryBaseAdapter = CountryBaseAdapter()
        listview.adapter = countryBaseAdapter
        listview.setOnItemClickListener { _, view, _, _ -> view.isSelected = true }
        listview.divider = AppCompatResources.getDrawable(this, R.drawable.divider)
    }
    fun observeData() {
        val localDataSource = LocalDataSource(resources)
        val repository = CountryRepo(localDataSource)
        val factory = CountryViewModel.Factory(repository)
        val viewModel = ViewModelProvider(this, factory)[CountryViewModel::class.java]
        viewModel.countries.observe(this) {
            countryBaseAdapter.updateListCountry(it)
        }
        viewModel.loadCountries()
    }
}