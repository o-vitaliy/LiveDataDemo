package com.example.livedatademo

import android.app.Application
import com.example.livedatademo.di.components.AppComponent
import com.example.livedatademo.di.components.DaggerAppComponent
import com.example.livedatademo.di.modules.AppModule

class App : Application() {

    val appComponent: AppComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}