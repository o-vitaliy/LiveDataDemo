package com.example.livedatademo.domain.user

import com.example.livedatademo.domain.user.model.User
import kotlinx.coroutines.experimental.Deferred

interface UserRepository {

    suspend fun getUser(name:String): Deferred<User>

}