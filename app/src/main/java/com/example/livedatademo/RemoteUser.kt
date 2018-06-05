package com.example.livedatademo

import kotlinx.coroutines.experimental.delay

class RemoteUser {

    suspend fun getRemoteUser(): User {
        delay(5000)
        return User("1", "Alfred")
    }

}