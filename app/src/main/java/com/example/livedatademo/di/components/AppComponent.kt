package com.example.livedatademo.di.components

import android.content.Context
import com.example.livedatademo.di.modules.AppModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {

    fun context(): Context

    fun retrofit(): Retrofit

}