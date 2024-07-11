package com.example.graphqldemoapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqldemoapp.domain.CountryDetail
import com.example.graphqldemoapp.domain.GetCountriesUseCase
import com.example.graphqldemoapp.domain.GetCountryDetailUseCase
import com.example.graphqldemoapp.domain.SingleCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryDetailUseCase: GetCountryDetailUseCase
): ViewModel() {

    private  val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

init {
    viewModelScope.launch {
        _state.update { it.copy(
            isLoading = true
        ) }
        _state.update { it.copy(
            countries = getCountriesUseCase.execute(),
            isLoading = false
        ) }
    }
}
    fun selectCountry(code:String){
        viewModelScope.launch {
            _state.update { it.copy(
                selectedCountry = getCountryDetailUseCase.execute(code)
            ) }
        }
    }

    fun dismissCountryDetailDialog(){
        _state.update { it.copy(
            selectedCountry = null
        ) }
    }
    data class CountriesState(
        val countries: List<SingleCountry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCountry: CountryDetail? = null
    )
}