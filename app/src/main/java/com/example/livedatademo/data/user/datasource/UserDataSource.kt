package com.example.livedatademo.data.user.datasource

import com.example.livedatademo.data.user.entity.UserEntity

interface UserDataSource {

    fun getUser(name: String): UserEntity

}