package com.example.livedatademo.di.modules

import com.example.livedatademo.data.repos.datasource.RemoteRepoDataSource
import com.example.livedatademo.data.repos.datasource.RepoDataSource
import com.example.livedatademo.data.search.datasource.RemoteSearchDataSource
import com.example.livedatademo.data.search.datasource.SearchDataSource
import com.example.livedatademo.data.user.datasource.RemoteUserDataSource
import com.example.livedatademo.data.user.datasource.UserDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    internal abstract fun bindUserDataSource(dataSource: RemoteUserDataSource): UserDataSource

    @Binds
    internal abstract fun bindReposDataSource(dataSource: RemoteRepoDataSource): RepoDataSource

    @Binds
    internal abstract fun bindSearchDataSource(dataSource: RemoteSearchDataSource): SearchDataSource
}