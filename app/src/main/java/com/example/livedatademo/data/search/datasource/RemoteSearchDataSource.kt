package com.example.livedatademo.data.search.datasource

import com.example.livedatademo.data.search.SearchApi
import com.example.livedatademo.data.user.entity.UserEntity
import javax.inject.Inject

class RemoteSearchDataSource @Inject constructor(
        private val api: SearchApi
) : SearchDataSource {

    override fun searchUser(query: String): List<UserEntity> = api.searchUser(query).items
}