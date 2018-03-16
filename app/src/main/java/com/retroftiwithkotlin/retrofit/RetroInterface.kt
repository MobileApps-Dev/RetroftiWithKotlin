package com.retroftiwithkotlin.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetroInterface {

    @GET("/plc.app/api/franchise/GetStateByCountryId")
    fun getStateList(@Query("CountryId") centerId: Int): Call<StateResponse>

}