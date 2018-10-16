package com.example.livedatademo.di.modules

import com.example.livedatademo.data.repos.repository.RepoRepositoryImpl
import com.example.livedatademo.data.search.repository.SearchRepositoryImpl
import com.example.livedatademo.data.user.repository.UserRepositoryImpl
import com.example.livedatademo.domain.repos.RepoRepository
import com.example.livedatademo.domain.search.SearchRepository
import com.example.livedatademo.domain.user.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoriesModule {

    @Binds
    internal abstract fun bindUserRepository(repo: UserRepositoryImpl): UserRepository

    @Binds
    internal abstract fun bindRepoRepository(repo: RepoRepositoryImpl): RepoRepository

    @Binds
    internal abstract fun bindSearchRepository(repo: SearchRepositoryImpl): SearchRepository
}