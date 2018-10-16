package com.example.livedatademo.data.search.repository

import com.example.livedatademo.data.search.datasource.SearchDataSource
import com.example.livedatademo.data.user.mapper.UserEntityToModelMapper
import com.example.livedatademo.domain.search.SearchRepository
import com.example.livedatademo.domain.user.model.User
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
        private val searchDataSource: SearchDataSource,
        private val userEntityToModelMapper: UserEntityToModelMapper
) : SearchRepository {
    override fun searchUsers(query: String): List<User> =
            userEntityToModelMapper.map(searchDataSource.searchUser(query))
}