package com.example.graphqldemoapp.di

import androidx.annotation.Size
import com.apollographql.apollo3.ApolloClient
import com.example.graphqldemoapp.data.ApolloCountryClient
import com.example.graphqldemoapp.domain.CountryClient
import com.example.graphqldemoapp.domain.GetCountriesUseCase
import com.example.graphqldemoapp.domain.GetCountryDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient() : ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideApolloCountryClient(apolloClient: ApolloClient): CountryClient{
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun providesGetCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)
    }
    @Provides
    @Singleton
    fun providesGetCountryDetailUseCase(countryClient: CountryClient): GetCountryDetailUseCase{
        return GetCountryDetailUseCase(countryClient)
    }
}