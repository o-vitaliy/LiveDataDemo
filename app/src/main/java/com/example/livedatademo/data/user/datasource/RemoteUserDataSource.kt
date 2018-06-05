package com.example.livedatademo.data.user.datasource

import com.example.livedatademo.data.user.UserApi

class RemoteUserDataSource(private val api: UserApi) : UserDataSource {

    override fun getUser(name: String) =
            checkNotNull(api.getUser(name))
}