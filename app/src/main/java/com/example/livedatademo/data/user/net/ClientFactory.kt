package com.example.livedatademo.data.user.net

import okhttp3.OkHttpClient

class ClientFactory {

    fun create():OkHttpClient = OkHttpClient.Builder().build()

}