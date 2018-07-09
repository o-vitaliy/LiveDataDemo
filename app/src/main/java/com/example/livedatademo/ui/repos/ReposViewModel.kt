package com.example.livedatademo.ui.repos

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.livedatademo.domain.repos.usecase.GetReposUseCase
import com.xwray.groupie.Group
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject
import com.example.livedatademo.ui.repos.mappers.RepoMapper

class ReposViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase,
    private val repoMapper: RepoMapper
) : ViewModel() {

    private val userMutable = MutableLiveData<List<Group>>()
    val items: LiveData<List<Group>> = userMutable

    private val loadingMutable = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = loadingMutable

    init {
        loadRepos()
    }

    private fun loadRepos() {
        launch {
            getReposUseCase.beforeExecute = { loadingMutable.postValue(true) }
            getReposUseCase.terminated = { loadingMutable.postValue(false) }
            val r = getReposUseCase.execute(GetReposUseCase.Params("o-vitaliy"))
                .await()
                .data
                ?.map { repoMapper.map(it) }
            r?.let {
                userMutable.postValue(it)
            }
        }
    }
}
