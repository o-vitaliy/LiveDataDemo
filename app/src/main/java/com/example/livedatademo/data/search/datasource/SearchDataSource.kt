package com.example.livedatademo.data.search.datasource

import com.example.livedatademo.data.user.entity.UserEntity

interface SearchDataSource {

    fun searchUser(query: String): List<UserEntity>
}