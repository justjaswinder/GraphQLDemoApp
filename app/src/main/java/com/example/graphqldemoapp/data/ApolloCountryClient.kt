package com.example.graphqldemoapp.data

import com.apollographql.apollo3.ApolloClient
import com.example.graphqldemoapp.CountriesQuery
import com.example.graphqldemoapp.CountryQuery
import com.example.graphqldemoapp.domain.CountryClient
import com.example.graphqldemoapp.domain.CountryDetail
import com.example.graphqldemoapp.domain.SingleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient)
    : CountryClient {
    override suspend fun getCountries(): List<SingleCountry> {
      return apolloClient
          .query(CountriesQuery())
          .execute()
          .data
          ?.countries
          ?.map { it.toSingleCountry() }
        ?: emptyList()
    }

    override suspend fun getCountryData(code: String): CountryDetail? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toCountryDetail()
    }

}