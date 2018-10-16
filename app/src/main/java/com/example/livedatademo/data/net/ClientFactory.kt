package com.example.livedatademo.data.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class ClientFactory {

    fun create(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

}