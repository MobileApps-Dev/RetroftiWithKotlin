package com.retroftiwithkotlin.retrofit

import com.retroftiwithkotlin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    fun create(): RetroInterface {
        val client = OkHttpClient()
                .newBuilder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://preventine.org:88")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(RetroInterface::class.java)
    }

}