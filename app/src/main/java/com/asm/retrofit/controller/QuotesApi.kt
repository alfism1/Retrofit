package com.asm.retrofit.controller

import com.asm.retrofit.model.QuoteList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes ():Response<QuoteList>
}