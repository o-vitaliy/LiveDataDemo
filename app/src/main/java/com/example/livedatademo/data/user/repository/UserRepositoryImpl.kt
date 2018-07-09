package com.example.livedatademo.data.user.repository

import com.example.livedatademo.data.user.datasource.UserDataSource
import com.example.livedatademo.data.user.mapper.UserEntityToModelMapper
import com.example.livedatademo.domain.user.UserRepository
import com.example.livedatademo.domain.user.model.User
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
        private val userDataSource: UserDataSource,
        private val userEntityToModelMapper: UserEntityToModelMapper
) : UserRepository {
    override suspend fun getUser(name: String): Deferred<User> = async {
        val userEntity = userDataSource.getUser(name)
        userEntityToModelMapper.map(userEntity)
    }
}