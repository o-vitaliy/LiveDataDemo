package com.example.livedatademo.domain.search

import com.example.livedatademo.domain.user.model.User

interface SearchRepository {

    fun searchUsers(query: String): List<User>
}