package com.example.livedatademo.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.livedatademo.di.qualifier.ViewModelKey
import com.example.livedatademo.ui.common.ViewModelFactory
import com.example.livedatademo.ui.main.MainViewModel
import com.example.livedatademo.ui.repos.ReposViewModel
import com.example.livedatademo.ui.userSearch.UserSearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun postListViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    internal abstract fun postReposViewModel(viewModel: ReposViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserSearchViewModel::class)
    internal abstract fun postUserSearchViewModel(viewModel: UserSearchViewModel): ViewModel

//Add more ViewModels here
}