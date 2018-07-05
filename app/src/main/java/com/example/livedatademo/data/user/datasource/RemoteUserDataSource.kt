package com.example.livedatademo.data.user.datasource

import com.example.livedatademo.data.user.UserApi
import javax.inject.Inject

class RemoteUserDataSource @Inject constructor(
        private val api: UserApi
) : UserDataSource {

    override fun getUser(name: String) =
            checkNotNull(api.getUser(name))
}