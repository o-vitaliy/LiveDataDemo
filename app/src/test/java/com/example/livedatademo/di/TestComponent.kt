package com.example.livedatademo.di

import com.example.livedatademo.data.user.UserApiTest
import com.example.livedatademo.data.user.datasource.RemoteUserDataSourceTest
import com.example.livedatademo.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface TestComponent {

    fun inject(api: UserApiTest)
}