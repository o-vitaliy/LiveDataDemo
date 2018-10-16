package com.example.livedatademo.data.search

import com.example.livedatademo.data.search.response.SearchResponse
import com.example.livedatademo.data.user.entity.UserEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("search/users")
    fun searchUser(@Query("q") query: String): SearchResponse<UserEntity>

}