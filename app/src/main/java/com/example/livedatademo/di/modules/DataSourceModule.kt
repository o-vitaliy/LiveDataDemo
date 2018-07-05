package com.example.livedatademo.di.modules

import com.example.livedatademo.data.user.datasource.RemoteUserDataSource
import com.example.livedatademo.data.user.datasource.UserDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    internal abstract fun bindUserDataSource(factory: RemoteUserDataSource): UserDataSource

}