package com.example.livedatademo

import com.example.livedatademo.di.components.DaggerAppComponent
import com.example.livedatademo.di.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}