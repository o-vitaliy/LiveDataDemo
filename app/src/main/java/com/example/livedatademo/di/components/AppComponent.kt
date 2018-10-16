package com.example.livedatademo.di.components

import android.content.Context
import com.example.livedatademo.di.modules.*
import com.example.livedatademo.ui.main.MainFragment
import com.example.livedatademo.ui.repos.ReposFragment
import com.example.livedatademo.ui.userSearch.UserSearchFragment
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityBuilder::class,
    AppModule::class,
    ApiModule::class,
    DataSourceModule::class,
    RepositoriesModule::class,
    ViewModelModule::class
])
interface AppComponent {

    fun context(): Context

    fun retrofit(): Retrofit

    fun inject(f: MainFragment)
    fun inject(f: ReposFragment)
    fun inject(f: UserSearchFragment)
}