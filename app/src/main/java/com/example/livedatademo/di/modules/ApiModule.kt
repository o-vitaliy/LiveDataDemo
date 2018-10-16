package com.example.livedatademo.di.modules

import com.example.livedatademo.data.repos.ReposApi
import com.example.livedatademo.data.search.SearchApi
import com.example.livedatademo.data.user.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    fun provideReposApi(retrofit: Retrofit): ReposApi = retrofit.create(ReposApi::class.java)

    @Provides
    fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)
}