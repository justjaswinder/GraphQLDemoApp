package com.example.graphqldemoapp.domain

data class CountryDetail(
    val code:String,
    val name:String,
    val emoji:String,
    val capital:String,
    val currency:String,
    val languages:List<String>,
    val continent:String)

