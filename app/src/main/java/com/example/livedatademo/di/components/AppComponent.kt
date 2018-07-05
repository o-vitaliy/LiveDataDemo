package com.example.livedatademo.di.components

import android.content.Context
import com.example.livedatademo.App
import com.example.livedatademo.di.modules.ActivityBuilder
import com.example.livedatademo.di.modules.ApiModule
import com.example.livedatademo.di.modules.AppModule
import com.example.livedatademo.di.modules.DataSourceModule
import com.example.livedatademo.di.modules.RepositoriesModule
import com.example.livedatademo.di.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilder::class,
    AppModule::class,
    ApiModule::class,
    DataSourceModule::class,
    RepositoriesModule::class,
    ViewModelModule::class
])
interface AppComponent : AndroidInjector<App> {

    fun context(): Context

    fun retrofit(): Retrofit

}