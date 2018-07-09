package com.example.livedatademo.di.modules

import com.example.livedatademo.data.repos.ReposApi
import com.example.livedatademo.data.user.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun provideUserApi(retrofit: Retrofit) = retrofit.create(UserApi::class.java)

    @Provides
    fun provideReposApi(retrofit: Retrofit) = retrofit.create(ReposApi::class.java)

}