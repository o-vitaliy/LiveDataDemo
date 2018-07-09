package com.example.livedatademo.data.repos

import com.example.livedatademo.data.repos.entity.RepoEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface ReposApi {

    @GET("users/{name}/repos")
    fun getRepos(@Path("name") name: String): List<RepoEntity>
}