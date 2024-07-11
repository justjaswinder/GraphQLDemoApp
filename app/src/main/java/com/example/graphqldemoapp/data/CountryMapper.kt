package com.example.graphqldemoapp.data

import com.example.graphqldemoapp.CountriesQuery
import com.example.graphqldemoapp.CountryQuery
import com.example.graphqldemoapp.domain.CountryDetail
import com.example.graphqldemoapp.domain.SingleCountry

fun CountryQuery.Country.toCountryDetail(): CountryDetail{
    return CountryDetail(
        code = code,
        name =  name,
        emoji = emoji,
        capital = capital ?: "No Capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name},
        continent = continent.name  )
}

fun CountriesQuery.Country.toSingleCountry(): SingleCountry{
    return SingleCountry(
        code = code,
        name =  name,
        emoji = emoji,
        capital = capital ?: "No Capital")
}