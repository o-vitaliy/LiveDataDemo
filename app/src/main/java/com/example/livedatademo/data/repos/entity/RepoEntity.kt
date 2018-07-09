package com.example.livedatademo.data.repos.entity

import com.google.gson.annotations.SerializedName

data class RepoEntity(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)

