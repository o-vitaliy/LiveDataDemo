package com.example.livedatademo.data.repos.datasource

import com.example.livedatademo.data.repos.ReposApi
import javax.inject.Inject

class RemoteRepoDataSource @Inject constructor(
        private val api: ReposApi
) : RepoDataSource {

    override fun getRepos(name: String) =
            checkNotNull(api.getRepos(name))
}