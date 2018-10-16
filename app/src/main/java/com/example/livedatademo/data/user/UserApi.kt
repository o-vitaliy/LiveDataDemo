package com.example.livedatademo.data.user

import com.example.livedatademo.data.user.entity.UserEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users/{name}")
    fun getUser(@Path("name") name: String): UserEntity

}