package com.example.livedatademo.di.modules

import com.example.livedatademo.MainActivity
import com.example.livedatademo.ui.main.MainFragment
import com.example.livedatademo.ui.repos.ReposFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun bindReposFragment(): ReposFragment
}