package com.demo.data.model

data class SearchData (
        val searchId: Int ,
        val searchName: String ,
        val flagUrl: String = "",
        val countryName: String = "",
        var selected: Boolean)