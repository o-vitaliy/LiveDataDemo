package com.example.livedatademo

import com.example.livedatademo.domain.user.model.User
import kotlinx.coroutines.experimental.delay

class RemoteUser {

    suspend fun getRemoteUser(): User {
        delay(5000)
        return User("1", "Alfred")
    }

}