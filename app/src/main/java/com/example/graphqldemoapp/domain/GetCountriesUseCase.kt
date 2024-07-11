package com.example.graphqldemoapp.domain

class GetCountriesUseCase(
    private val countryClient: CountryClient) {

   suspend fun execute(): List<SingleCountry>{
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }

}