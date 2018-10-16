package com.example.livedatademo.data.user.entity

import com.google.gson.annotations.SerializedName

data class UserEntity(

        @SerializedName("id") val id: String,
        @SerializedName("login") val name: String,
        @SerializedName("avatar_url") val avatarUrl: String,
        @SerializedName("url") val url: String

)

