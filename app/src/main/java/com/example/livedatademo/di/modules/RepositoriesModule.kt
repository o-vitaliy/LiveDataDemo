package com.example.livedatademo.di.modules

import com.example.livedatademo.data.user.repository.UserRepositoryImpl
import com.example.livedatademo.domain.user.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoriesModule {

    @Binds
    internal abstract fun bindUserRepository(repo: UserRepositoryImpl): UserRepository

}