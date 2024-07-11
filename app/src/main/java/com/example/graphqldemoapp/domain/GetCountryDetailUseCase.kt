package com.example.graphqldemoapp.domain

class GetCountryDetailUseCase(
    private val countryClient: CountryClient
) {
        suspend fun execute(code: String): CountryDetail?{
            return countryClient.getCountryData(code)
        }
}