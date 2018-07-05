package com.example.livedatademo.data.net

import retrofit2.Response

object ResponseDeserializer {
    const val DEFAULT_ERROR_MESSAGE = "something awful has happened"

    fun <T : Any?> deserializer(r: Response<T>): T? {
        return if (r.isSuccessful)
            r.body()
        else
            error(r.errorBody()?.string() ?: r.message() ?: DEFAULT_ERROR_MESSAGE)
    }


}