package com.example.livedatademo.domain.repos

import com.example.livedatademo.domain.repos.model.Repo
import kotlinx.coroutines.experimental.Deferred

interface RepoRepository {

    suspend fun getRepos(name:String): Deferred<List<Repo>>

}