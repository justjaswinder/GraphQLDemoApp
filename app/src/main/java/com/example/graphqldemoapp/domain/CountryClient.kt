package com.example.graphqldemoapp.domain

interface CountryClient {
   suspend fun getCountries(): List<SingleCountry>
   suspend fun getCountryData( code :String): CountryDetail?
}